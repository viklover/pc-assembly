package ru.viklover.pcassembly.ram.type

import org.springframework.data.annotation.Id

data class RamType(
    @Id
    val id: Int,
    val name: String
)