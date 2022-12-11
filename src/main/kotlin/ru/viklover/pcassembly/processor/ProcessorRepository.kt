package ru.viklover.pcassembly.processor

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import ru.viklover.pcassembly.util.SqlQueryBuilder

@Repository
class ProcessorRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlQueryBuilder: SqlQueryBuilder
) {

    fun create(processor: Processor): String {

        val parameters = MapSqlParameterSource()
        parameters.addValue("name", processor.name)
        parameters.addValue("architecture", processor.architecture.name)
        parameters.addValue("speed", processor.speed)
        parameters.addValue("memory_type", processor.memoryType.name)
        parameters.addValue("max_memory_capacity", processor.maxMemoryCapacity)

        template.update(sqlQueryBuilder.insert("Processor", parameters), parameters)

        return processor.name;
    }

    fun update(processor: Processor): Processor {

        val parameters = MapSqlParameterSource()
        parameters.addValue("architecture", processor.architecture.name)
        parameters.addValue("speed", processor.speed)
        parameters.addValue("memory_type", processor.memoryType.name)
        parameters.addValue("max_memory_capacity", processor.maxMemoryCapacity)

        val conditions = MapSqlParameterSource()
        conditions.addValue("name", processor.name)

        template.update(
            sqlQueryBuilder.update("Processor", parameters, conditions),
            parameters.addValues(conditions.values)
        )

        return template.query(
                sqlQueryBuilder.select("Processor", conditions),
                conditions,
                ProcessorRowMapper()).first();
    }

    fun findAll(): List<Processor> {
        return template.query(sqlQueryBuilder.select("Processor"), ProcessorRowMapper())
    }
}