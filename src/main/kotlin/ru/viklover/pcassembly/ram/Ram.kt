package ru.viklover.pcassembly.ram

import org.springframework.data.annotation.Id
import ru.viklover.pcassembly.model.PersistableImpl

data class Ram(
    @Id
    var id: Int,
    var name: String,
    var speed: Int,
    var capacity: Int
) : PersistableImpl<Int>(id)
