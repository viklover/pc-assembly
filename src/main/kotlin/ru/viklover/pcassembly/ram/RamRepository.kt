package ru.viklover.pcassembly.ram

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.viklover.pcassembly.cpu.CpuRowMapper

import ru.viklover.pcassembly.util.SqlPreparedStatementBuilder

@Repository
class RamRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder
) {

    fun create(ram: Ram): Ram {

        val parameters = MapSqlParameterSource()
        parameters.addValue("name", ram.name)
        parameters.addValue("type", ram.type)
        parameters.addValue("speed", ram.speed)
        parameters.addValue("capacity", ram.capacity)

        template.update(sqlPreparedStatementBuilder.insert("ram", parameters), parameters)

        return Ram(
            name = ram.name,
            type = ram.type,
            speed = ram.speed,
            capacity = ram.capacity
        )
    }

    fun update(ram: Ram): Ram {

        val parameters = MapSqlParameterSource()
        parameters.addValue("type", ram.type)
        parameters.addValue("speed", ram.speed)
        parameters.addValue("capacity", ram.capacity)

        val conditions = MapSqlParameterSource()
        conditions.addValue("name", ram.name)

        template.update(
                sqlPreparedStatementBuilder.update("ram", parameters, conditions),
                parameters.addValues(conditions.values)
        )

        return template.query(
                sqlPreparedStatementBuilder.select("ram", conditions),
                conditions,
                RamRowMapper()).first();
    }

    fun findAll(): List<Ram> {
        return template.query(sqlPreparedStatementBuilder.select("ram"), RamRowMapper())
    }
}