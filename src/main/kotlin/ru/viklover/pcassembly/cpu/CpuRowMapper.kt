package ru.viklover.pcassembly.cpu

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CpuRowMapper : RowMapper<Cpu> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Cpu {

        return Cpu(
                name = rs.getString("name"),
                architecture = rs.getString("architecture"),
                speed = rs.getInt("speed"),
                ramType = rs.getString("ram_type"),
                maxRamCapacity = rs.getInt("max_ram_capacity")
        )
    }

}