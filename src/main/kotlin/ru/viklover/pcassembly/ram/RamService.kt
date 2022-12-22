package ru.viklover.pcassembly.ram

import org.springframework.stereotype.Service

@Service
class RamService(
    private val ramRepository: RamRepository
) {

    fun create(ram: Ram): Ram {
        return ramRepository.save(ram)
    }

    fun update(ram: Ram): Ram {
        return ramRepository.save(ram)
    }

    fun findAll(): MutableIterable<Ram> {
        return ramRepository.findAll()
    }
}