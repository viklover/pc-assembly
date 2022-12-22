package ru.viklover.pcassembly.cpu

import org.springframework.stereotype.Service

@Service
class CpuService(
    private val cpuRepository: CpuRepository
) {

    fun create(cpu: Cpu): Cpu {
        return cpuRepository.save(cpu)
    }

    fun update(cpu: Cpu): Cpu {
        return cpuRepository.save(cpu)
    }

    fun findAll(): MutableIterable<Cpu> {
        return cpuRepository.findAll()
    }
}
