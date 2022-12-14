package ru.viklover.pcassembly.ram

import org.springframework.stereotype.Service

@Service
class RamService(
    private val ramRepository: RamRepository
) {

    fun create(ram: Ram): Ram {
        return ramRepository.create(ram)
    }

    fun update(ram: Ram): Ram {
        return ramRepository.update(ram)
    }

    fun findAll(): List<Ram> {
        return ramRepository.findAll();
    }
}