package ru.viklover.pcassembly.util.sql

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.stereotype.Service

@Service
class SqlPreparedStatementBuilder {

    fun selectAll(table: String): String {
        return "SELECT * FROM `$table`"
    }

    fun selectAll(table: String, conditions: MapSqlParameterSource): String {
        return selectAll(table) + " WHERE " + conditions.values.keys.joinToString(" AND ") { "$it = :$it" }
    }

    fun select(columns: List<String>, table: String): String {
        return "SELECT ${ columns.joinToString(", ") } FROM $table"
    }

    fun select(columns: List<String>, table: String, conditions: MapSqlParameterSource): String {
        return select(columns, table) + " " + where(conditions)
    }

    fun insert(table: String, parameters: MapSqlParameterSource): String {
        return "INSERT INTO `$table` " +
                "(${parameters.values.keys.joinToString(", ")}) VALUES " +
                "(${parameters.values.keys.joinToString(", ") { ":$it" }})"
    }

    fun update(table: String, parameters: MapSqlParameterSource, conditions: MapSqlParameterSource): String {
        return "UPDATE `${table}` SET ${parameters.values.keys.joinToString(", ") { "$it = :$it" }} " +
                where(conditions);
    }

    private fun where(conditions: MapSqlParameterSource): String {
        return "WHERE " + conditions.values.keys.joinToString(" AND ") { "$it = :$it" }
    }
}