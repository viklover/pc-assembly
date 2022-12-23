package ru.viklover.pcassembly.cpu

import org.springframework.stereotype.Service
import ru.viklover.pcassembly.cpu.architecture.CpuArchitectureService
import ru.viklover.pcassembly.ram.type.RamTypeService
import ru.viklover.pcassembly.util.IdService

@Service
class CpuService(
    private val cpuRepository: CpuRepository,
    private val cpuArchitectureService: CpuArchitectureService,
    private val ramTypeService: RamTypeService,
    private val idService: IdService
) {

    fun create(cpuDto: CpuDto): CpuDto {

        val partId = getLastPartId() + 1

        val newCpu = Cpu(
            id = idService.createIdByCpuArchitectureAndRamType(
                    cpuArchitectureService.findIdByName(cpuDto.architecture),
                    ramTypeService.findIdByName(cpuDto.ramType),
                    partId),
            name = cpuDto.name,
            speed = cpuDto.speed,
            maxRamCapacity = cpuDto.maxRamCapacity
        )

        newCpu.isNew = true

        cpuRepository.save(newCpu)

        return CpuDto (
                partId = partId,
                name = cpuDto.name,
                speed = cpuDto.speed,
                architecture = cpuDto.architecture,
                ramType = cpuDto.ramType,
                maxRamCapacity = cpuDto.maxRamCapacity
        )
    }

    fun update(cpuDto: CpuDto): CpuDto {

        val cpu = cpuRepository.findByPartId(cpuDto.partId)

        if (cpuArchitectureService.findById(idService.getCpuArchitectureFromId(cpu.id)) != cpuDto.architecture ||
                ramTypeService.findById(idService.getRamTypeFromId(cpu.id)) != cpuDto.ramType) {

            cpu.id = idService.createIdByCpuArchitectureAndRamType(
                    cpuArchitectureService.findIdByName(cpuDto.architecture),
                    ramTypeService.findIdByName(cpuDto.ramType),
                    cpuDto.partId
            )

            cpuRepository.updateIdByPartId(cpu.id, cpuDto.partId)
        }

        cpu.name = cpuDto.name
        cpu.speed = cpuDto.speed
        cpu.maxRamCapacity = cpuDto.maxRamCapacity

        cpuRepository.save(cpu)

        return cpuDto
    }

    fun findAll(): List<CpuDto> {
        return cpuRepository.findAll().map {
            return@map CpuDto (
                    partId = idService.getIdPartFromId(it.id),
                    name = it.name,
                    speed = it.speed,
                    architecture = cpuArchitectureService.findById(
                            idService.getCpuArchitectureFromId(it.id)),
                    ramType = ramTypeService.findById(
                            idService.getRamTypeFromId(it.id)
                    ),
                    maxRamCapacity = it.maxRamCapacity
            )
        }
    }

    fun getLastPartId(): Int {
        return cpuRepository.getLastPartId() ?: 0
    }
}
