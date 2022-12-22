package ru.viklover.pcassembly.ram.type

import org.springframework.stereotype.Service

@Service
class RamTypeService(
    private val ramTypeRepository: RamTypeRepository
) {

    fun findAll(): List<String> {
        return ramTypeRepository.findAll().map { it.name }
    }
}