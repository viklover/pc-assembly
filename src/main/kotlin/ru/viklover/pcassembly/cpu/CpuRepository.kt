package ru.viklover.pcassembly.cpu

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

import ru.viklover.pcassembly.util.SqlPreparedStatementBuilder

@Repository
class CpuRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder
) {

    fun create(cpu: Cpu): String {

        val parameters = MapSqlParameterSource()
        parameters.addValue("name", cpu.name)
        parameters.addValue("architecture", cpu.architecture)
        parameters.addValue("speed", cpu.speed)
        parameters.addValue("ram_type", cpu.ramType)
        parameters.addValue("max_ram_capacity", cpu.maxRamCapacity)

        template.update(sqlPreparedStatementBuilder.insert("cpu", parameters), parameters)

        return cpu.name;
    }

    fun update(cpu: Cpu): Cpu {

        val parameters = MapSqlParameterSource()
        parameters.addValue("architecture", cpu.architecture)
        parameters.addValue("speed", cpu.speed)
        parameters.addValue("ram_type", cpu.ramType)
        parameters.addValue("max_ram_capacity", cpu.maxRamCapacity)

        val conditions = MapSqlParameterSource()
        conditions.addValue("name", cpu.name)

        template.update(
            sqlPreparedStatementBuilder.update("cpu", parameters, conditions),
            parameters.addValues(conditions.values)
        )

        return template.query(
                sqlPreparedStatementBuilder.select("cpu", conditions),
                conditions,
                CpuRowMapper()).first();
    }

    fun findAll(): List<Cpu> {
        return template.query(sqlPreparedStatementBuilder.select("cpu"), CpuRowMapper())
    }
}