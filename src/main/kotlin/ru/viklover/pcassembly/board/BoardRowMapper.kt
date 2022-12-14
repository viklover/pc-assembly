package ru.viklover.pcassembly.board

import java.sql.ResultSet
import org.springframework.jdbc.core.RowMapper

class BoardRowMapper : RowMapper<Board> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Board {

        return Board(
                name = rs.getString("name"),
                cpuArchitecture = rs.getString("cpu_architecture"),
                ramType = rs.getString("ram_type"),
                ramSlots = rs.getInt("ram_slots")
        )
    }

}