package ru.viklover.pcassembly.assembly

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

data class Assembly(
    @Id var id: Int?C,
    var name: String,
    @JsonProperty("cpu_id") var cpuId: Int,
    @JsonProperty("board_id") var boardId: Int
)
