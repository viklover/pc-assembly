package ru.viklover.pcassembly.cpu

import org.springframework.data.annotation.Id
import ru.viklover.pcassembly.model.PersistableImpl

data class Cpu (
    @Id var id: Int,
    var name: String,
    var speed: Int,
    var maxRamCapacity: Int
) : PersistableImpl<Int>(id)
