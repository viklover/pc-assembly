package ru.viklover.pcassembly.service

import org.springframework.stereotype.Service
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

import ru.viklover.pcassembly.util.sql.SqlPreparedStatementBuilder
import ru.viklover.pcassembly.util.sql.column.Column
import ru.viklover.pcassembly.util.sql.column.ColumnMapper

@Service
class ModelService(
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder,
    private val template: NamedParameterJdbcTemplate
) {

    fun getModelFields(modelName: String): List<String> {

        val parameters = MapSqlParameterSource(mapOf("TABLE_NAME" to modelName))

        val fields = template.query(sqlPreparedStatementBuilder.select(
                listOf("COLUMN_NAME"), "INFORMATION_SCHEMA.COLUMNS", parameters), parameters, ColumnMapper());

        val transform: (Column) -> String = {it.COLUMN_NAME}

        return fields.map(transform);
    }
}