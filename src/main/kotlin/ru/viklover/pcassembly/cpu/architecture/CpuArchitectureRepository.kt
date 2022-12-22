package ru.viklover.pcassembly.cpu.architecture

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CpuArchitectureRepository : CrudRepository<CpuArchitecture, Long>