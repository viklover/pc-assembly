package ru.viklover.pcassembly.assembly.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UpdateAssemblyDto(
    var id: Int,
    var name: String,
    @JsonProperty("cpu_id") var cpuId: Int,
    @JsonProperty("board_id") var boardId: Int,
    var ram: List<Int>
)