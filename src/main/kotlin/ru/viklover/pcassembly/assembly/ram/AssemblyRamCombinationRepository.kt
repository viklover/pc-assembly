package ru.viklover.pcassembly.assembly.ram

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface AssemblyRamCombinationRepository : CrudRepository<AssemblyRamCombination, Int> {

    fun findByAssemblyId(assemblyId: Int?): List<AssemblyRamCombination>

    @Modifying
    @Query("delete from assembly_ram_combination where assembly_id = :assemblyId")
    fun deleteAllByAssemblyId(assemblyId: Int)
}