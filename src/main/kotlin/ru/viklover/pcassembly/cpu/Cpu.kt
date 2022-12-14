package ru.viklover.pcassembly.cpu

import com.fasterxml.jackson.annotation.JsonProperty

class Cpu(
    var name: String,
    var architecture: String,
    var speed: Int,
    @JsonProperty("ram_type") var ramType: String,
    @JsonProperty("max_ram_capacity") var maxRamCapacity: Int
)
