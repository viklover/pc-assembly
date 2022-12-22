package ru.viklover.pcassembly.cpu

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CpuRepository : CrudRepository<Cpu, Long>