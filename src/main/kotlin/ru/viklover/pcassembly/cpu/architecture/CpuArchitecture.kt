package ru.viklover.pcassembly.cpu.architecture

import org.springframework.data.annotation.Id

data class CpuArchitecture(
    @Id
    var id: Int,
    var name: String
)