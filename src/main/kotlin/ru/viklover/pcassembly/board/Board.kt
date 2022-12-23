package ru.viklover.pcassembly.board

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id

import ru.viklover.pcassembly.model.PersistableImpl

data class Board(
    @Id var id: Int,
    var name: String,
    @JsonProperty("ram_slots") var ramSlots: Int
) : PersistableImpl<Int>(id)