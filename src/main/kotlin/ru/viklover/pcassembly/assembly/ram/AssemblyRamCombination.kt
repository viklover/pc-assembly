package ru.viklover.pcassembly.assembly.ram

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

data class AssemblyRamCombination(
    @Id var id: Int?,
    @JsonProperty("assembly_id") var assemblyId: Int?,
    @JsonProperty("ram_id") var ramId: Int?,
    var count: Int = 0
)