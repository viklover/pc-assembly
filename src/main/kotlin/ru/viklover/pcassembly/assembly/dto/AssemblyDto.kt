package ru.viklover.pcassembly.assembly.dto

import com.fasterxml.jackson.annotation.JsonProperty

import ru.viklover.pcassembly.board.BoardDto
import ru.viklover.pcassembly.cpu.CpuDto
import ru.viklover.pcassembly.ram.RamDto

data class AssemblyDto(
    val id: Int,
    val name: String,
    val cpu: CpuDto,
    val board: BoardDto,
    @JsonProperty("ram_combination") val ramCombination: List<RamDto>
)
