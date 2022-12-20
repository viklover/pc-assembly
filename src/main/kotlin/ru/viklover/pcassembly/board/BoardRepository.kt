package ru.viklover.pcassembly.board

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

import ru.viklover.pcassembly.service.ModelService
import ru.viklover.pcassembly.util.sql.SqlPreparedStatementBuilder

@Repository
class BoardRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder,
    private val modelService: ModelService
) {

    fun create(board: Board): Board {

        val parameters = MapSqlParameterSource()
        parameters.addValue("name", board.name)
        parameters.addValue("cpu_architecture", board.cpuArchitecture)
        parameters.addValue("ram_type", board.ramType)
        parameters.addValue("ram_slots", board.ramSlots)

        template.update(sqlPreparedStatementBuilder.insert("board", parameters), parameters)

        return Board(
                name = board.name,
                cpuArchitecture = board.cpuArchitecture,
                ramType = board.ramType,
                ramSlots = board.ramSlots
        )
    }

    fun update(board: Board): Board {

        val parameters = MapSqlParameterSource()
        parameters.addValue("cpu_architecture", board.cpuArchitecture)
        parameters.addValue("ram_type", board.ramType)
        parameters.addValue("ram_slots", board.ramSlots)

        val conditions = MapSqlParameterSource()
        conditions.addValue("name", board.name)

        template.update(
                sqlPreparedStatementBuilder.update("board", parameters, conditions),
                parameters.addValues(conditions.values)
        )

        return template.query(
                sqlPreparedStatementBuilder.selectAll("board", conditions),
                conditions,
                BoardRowMapper()).first();
    }

    fun findAll(): List<Board> {
        return template.query(sqlPreparedStatementBuilder.selectAll("board"), BoardRowMapper())
    }

    fun getModelFields(): List<String> {
        return modelService.getModelFields("board")
    }
}