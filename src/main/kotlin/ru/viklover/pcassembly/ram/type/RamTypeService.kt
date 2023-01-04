package ru.viklover.pcassembly.ram.type

import org.springframework.stereotype.Service

@Service
class RamTypeService(
    private val ramTypeRepository: RamTypeRepository
) {

    fun findAll(): List<String> {
        return ramTypeRepository.findAll().map { it.name }
    }

    fun findById(id: Int): String {
        return ramTypeRepository.findById(id).get().name
    }

    fun findIdByName(name: String): Int {
        return ramTypeRepository.findByName(name).id
    }
}