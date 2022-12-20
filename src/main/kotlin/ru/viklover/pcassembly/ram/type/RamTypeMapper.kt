package ru.viklover.pcassembly.ram.type

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class RamTypeMapper : RowMapper<RamType> {

    override fun mapRow(rs: ResultSet, rowNum: Int): RamType {

        return RamType(
            name = rs.getString("name")
        )
    }
}