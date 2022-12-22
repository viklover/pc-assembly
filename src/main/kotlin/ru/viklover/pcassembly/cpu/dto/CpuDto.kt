package ru.viklover.pcassembly.cpu.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CpuDto(
    @JsonProperty("id") var partId: Int,
    var name: String,
    var architecture: String,
    var speed: Int,
    @JsonProperty("ram_type") var ramType: String,
    @JsonProperty("max_ram_capacity") var maxRamCapacity: Int
)