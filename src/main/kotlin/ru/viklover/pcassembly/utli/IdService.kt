package ru.viklover.pcassembly.utli

import org.springframework.stereotype.Service

@Service
class IdService {

    fun createIdByCpuArchitectureAndRamType(cpuArchitecture: Int, ramType: Int, id: Int): Int {
        return ((cpuArchitecture shl 4 or ramType) shl 8) or id
    }

    // Oh no, what's wrong with naming of method? :(
    fun getIdPartFromId(id: Int): Int {
        return id and 0x0F
    }

    fun getCpuArchitectureFromId(id: Int): Int {
        return id shr 12
    }

    fun getRamTypeFromId(id: Int): Int {
        return (id shr 8) and 0x0F
    }
}