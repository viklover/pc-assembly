package ru.viklover.pcassembly.cpu

import org.springframework.stereotype.Service

@Service
class CpuService(
    private val cpuRepository: CpuRepository
) {

    fun create(cpu: Cpu): Cpu {

        return Cpu(
                name = cpuRepository.create(cpu),
                architecture = cpu.architecture,
                speed = cpu.speed,
                ramType = cpu.ramType,
                maxRamCapacity = cpu.maxRamCapacity
        )
    }

    fun update(cpu: Cpu): Cpu {
        return cpuRepository.update(cpu)
    }

    fun findAll(): List<Cpu> {
        return cpuRepository.findAll();
    }
}
