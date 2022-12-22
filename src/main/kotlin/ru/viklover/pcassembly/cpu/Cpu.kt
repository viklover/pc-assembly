package ru.viklover.pcassembly.cpu

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

import com.fasterxml.jackson.annotation.JsonProperty

@Table
data class Cpu(
    @Id
    var id: Long,
    var name: String,
    var architecture: String,
    var speed: Int,
    @JsonProperty("ram_type") var ramType: String,
    @JsonProperty("max_ram_capacity") var maxRamCapacity: Int
)
