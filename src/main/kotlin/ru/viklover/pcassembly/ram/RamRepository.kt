package ru.viklover.pcassembly.ram

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RamRepository : CrudRepository<Ram, Int>