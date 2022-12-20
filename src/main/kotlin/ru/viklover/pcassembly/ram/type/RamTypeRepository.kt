package ru.viklover.pcassembly.ram.type

import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

import ru.viklover.pcassembly.util.sql.SqlPreparedStatementBuilder

@Repository
class RamTypeRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder
) {

    fun findAll(): List<String> {

        val list: List<RamType> = template.query(
                sqlPreparedStatementBuilder.selectAll("ram_type"), RamTypeMapper())

        val transform: (RamType) -> String = {it.name}

        return list.map(transform);
    }
}