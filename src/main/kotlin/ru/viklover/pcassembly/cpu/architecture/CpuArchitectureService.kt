package ru.viklover.pcassembly.cpu.architecture

import org.springframework.stereotype.Service

@Service
class CpuArchitectureService(
    private val cpuArchitectureRepository: CpuArchitectureRepository
) {

    fun findAll(): List<String> {
        return cpuArchitectureRepository.findAll().map { it.name }
    }

    fun findById(id: Int): String {
        return cpuArchitectureRepository.findById(id).get().name
    }

    fun findIdByName(name: String): Int {
        return cpuArchitectureRepository.findByName(name).id
    }
}