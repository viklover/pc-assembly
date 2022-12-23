package ru.viklover.pcassembly.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable

open class PersistableImpl<ID>(id: ID) : Persistable<ID> {

    @Transient
    @JsonIgnore
    private var _id: ID = id

    @Transient
    @JsonIgnore
    private var _isNew = false

    fun setNew(value: Boolean) {
        _isNew = value
    }

    override fun isNew(): Boolean = _isNew
    override fun getId(): ID = _id
}