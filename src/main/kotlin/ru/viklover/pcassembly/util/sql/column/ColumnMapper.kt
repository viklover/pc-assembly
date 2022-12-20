package ru.viklover.pcassembly.util.sql.column

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class ColumnMapper : RowMapper<Column> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Column {

        return Column(
            COLUMN_NAME = rs.getString("COLUMN_NAME")
        )
    }
}