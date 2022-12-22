package ru.viklover.pcassembly.ram.type

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RamTypeRepository : CrudRepository<RamType, Int> {
    fun findByName(name: String): RamType
}