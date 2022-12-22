package ru.viklover.pcassembly.ram.type

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RamTypeRepository : CrudRepository<RamType, Long>