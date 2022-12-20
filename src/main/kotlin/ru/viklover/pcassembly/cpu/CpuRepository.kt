package ru.viklover.pcassembly.cpu

import org.springframework.stereotype.Repository

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

import ru.viklover.pcassembly.service.ModelService
import ru.viklover.pcassembly.util.sql.SqlPreparedStatementBuilder

@Repository
class CpuRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder,
    private val modelService: ModelService
) {

    fun create(cpu: Cpu): Cpu {

        val parameters = MapSqlParameterSource()
        parameters.addValue("name", cpu.name)
        parameters.addValue("architecture", cpu.architecture)
        parameters.addValue("speed", cpu.speed)
        parameters.addValue("ram_type", cpu.ramType)
        parameters.addValue("max_ram_capacity", cpu.maxRamCapacity)

        template.update(sqlPreparedStatementBuilder.insert("cpu", parameters), parameters)

        return Cpu(
            name = cpu.name,
            architecture = cpu.architecture,
            speed = cpu.speed,
            ramType = cpu.ramType,
            maxRamCapacity = cpu.maxRamCapacity
        )
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
                sqlPreparedStatementBuilder.selectAll("cpu", conditions),
                conditions,
                CpuRowMapper()).first();
    }

    fun findAll(): List<Cpu> {
        return template.query(sqlPreparedStatementBuilder.selectAll("cpu"), CpuRowMapper())
    }

    fun getModelFields(): List<String> {
        return modelService.getModelFields("cpu")
    }
}