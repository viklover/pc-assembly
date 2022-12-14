package ru.viklover.pcassembly.ram

import java.sql.ResultSet
import org.springframework.jdbc.core.RowMapper

import ru.viklover.pcassembly.ram.Ram

class RamRowMapper : RowMapper<Ram> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Ram {

        return Ram(
                name = rs.getString("name"),
                type = rs.getString("type"),
                speed = rs.getInt("speed"),
                capacity = rs.getInt("capacity")
        )
    }

}