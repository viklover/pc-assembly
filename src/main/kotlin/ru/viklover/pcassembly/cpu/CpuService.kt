package ru.viklover.pcassembly.cpu

import org.springframework.stereotype.Service

@Service
class CpuService(
    private val cpuRepository: CpuRepository
) {

    fun create(cpu: Cpu): Cpu {
        return cpuRepository.create(cpu)
    }

    fun update(cpu: Cpu): Cpu {
        return cpuRepository.update(cpu)
    }

    fun findAll(): List<Cpu> {
        return cpuRepository.findAll();
    }

    fun getModelFields(): List<String> {
        return cpuRepository.getModelFields();
    }

}
