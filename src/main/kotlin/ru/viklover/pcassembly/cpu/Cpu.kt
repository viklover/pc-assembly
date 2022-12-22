package ru.viklover.pcassembly.cpu

import com.fasterxml.jackson.annotation.JsonIgnore

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable

data class Cpu (
    @Id var id: Int,
    var name: String,
    var speed: Int,
    var maxRamCapacity: Int
) : Persistable<Int> {

    @Transient
    @JsonIgnore
    private var _isNew = false

    fun setNew(value: Boolean) {
        _isNew = value
    }

    override fun isNew(): Boolean = _isNew
    override fun getId(): Int = id
}
