package ru.viklover.pcassembly.ram

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

data class RamDto(
    @Id @JsonProperty("id") var partId: Int,
    var name: String,
    var type: String,
    var speed: Int,
    var capacity: Int
)