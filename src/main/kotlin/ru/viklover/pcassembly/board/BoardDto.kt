package ru.viklover.pcassembly.board

import com.fasterxml.jackson.annotation.JsonProperty

import org.springframework.data.annotation.Id

data class BoardDto(
    @Id @JsonProperty("id") var partId: Int,
    var name: String,
    @JsonProperty("cpu_architecture") var cpuArchitecture: String,
    @JsonProperty("ram_type") var ramType: String,
    @JsonProperty("ram_slots") var ramSlots: Int
)