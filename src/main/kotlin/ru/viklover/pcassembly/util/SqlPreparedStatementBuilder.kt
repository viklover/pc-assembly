package ru.viklover.pcassembly.util

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.stereotype.Service

@Service
class SqlPreparedStatementBuilder {

    fun select(table: String): String {
        return "SELECT * FROM `$table`"
    }

    fun select(table: String, conditions: MapSqlParameterSource): String {
        return "SELECT * FROM `$table` WHERE " + conditions.values.keys.joinToString(" AND ") { "$it = :$it" }
    }

    fun insert(table: String, parameters: MapSqlParameterSource): String {
        return "INSERT INTO `$table` " +
                "(${parameters.values.keys.joinToString(", ")}) VALUES " +
                "(${parameters.values.keys.joinToString(", ") { ":$it" }})"
    }

    fun update(table: String, parameters: MapSqlParameterSource, conditions: MapSqlParameterSource): String {
        return "UPDATE `${table}` SET ${parameters.values.keys.joinToString(", ") { "$it = :$it" }} WHERE " +
                conditions.values.keys.joinToString(" AND ") { "$it = :$it" }
    }
}