package ru.viklover.pcassembly.cpu.architecture

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CpuArchitectureMapper : RowMapper<CpuArchitecture> {

    override fun mapRow(rs: ResultSet, rowNum: Int): CpuArchitecture {

        return CpuArchitecture(
            name = rs.getString("name")
        )
    }

}