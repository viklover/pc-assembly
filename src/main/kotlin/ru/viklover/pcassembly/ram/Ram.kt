package ru.viklover.pcassembly.ram

import org.springframework.data.annotation.Id

data class Ram(
    @Id
    var id: Int?,
    var name: String,
    var type: String,
    var speed: Int,
    var capacity: Int
)
