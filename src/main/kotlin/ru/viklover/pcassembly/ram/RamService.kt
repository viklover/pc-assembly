package ru.viklover.pcassembly.ram

import org.springframework.stereotype.Service

import ru.viklover.pcassembly.ram.type.RamTypeService
import ru.viklover.pcassembly.util.IdService

@Service
class RamService(
    private val ramRepository: RamRepository,
    private val ramTypeService: RamTypeService,
    private val idService: IdService
) {

    companion object {
        const val CPU_ARCHITECTURE = 0xF
    }

    fun create(ramDto: RamDto): RamDto {

        val partId = getLastPartId() + 1

        val newRam = Ram(
                id = idService.createIdByCpuArchitectureAndRamType(
                        CPU_ARCHITECTURE,
                        ramTypeService.findIdByName(ramDto.type),
                        partId),
                name = ramDto.name,
                speed = ramDto.speed,
                capacity = ramDto.capacity
        )

        newRam.isNew = true

        ramRepository.save(newRam)

        return RamDto(
                partId = partId,
                name = ramDto.name,
                speed = ramDto.speed,
                type = ramDto.type,
                capacity = ramDto.capacity
        )
    }

    fun update(ramDto: RamDto): RamDto {

        val ram = ramRepository.findByPartId(ramDto.partId)

        if (ramTypeService.findById(idService.getRamTypeFromId(ram.id)) != ramDto.type) {

            ram.id = idService.createIdByCpuArchitectureAndRamType(
                    CPU_ARCHITECTURE,
                    ramTypeService.findIdByName(ramDto.type),
                    ramDto.partId
            )

            ramRepository.updateIdByPartId(ram.id, ramDto.partId)
        }

        ram.name = ramDto.name
        ram.speed = ramDto.speed
        ram.capacity = ramDto.capacity

        ramRepository.save(ram)

        return ramDto
    }

    fun findAll(): List<RamDto> {
        return ramRepository.findAll().map {
            return@map RamDto(
                    partId = idService.getIdPartFromId(it.id),
                    name = it.name,
                    speed = it.speed,
                    capacity = it.capacity,
                    type = ramTypeService.findById(idService.getRamTypeFromId(it.id)),
            )
        }
    }

    fun getLastPartId(): Int {
        return ramRepository.getLastPartId() ?: 0
    }
}