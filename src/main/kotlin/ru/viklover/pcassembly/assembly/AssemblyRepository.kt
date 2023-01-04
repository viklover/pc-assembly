package ru.viklover.pcassembly.assembly

import org.springframework.data.repository.CrudRepository

interface AssemblyRepository : CrudRepository<Assembly, Int> {}