package ru.viklover.pcassembly.cpu.architecture

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import ru.viklover.pcassembly.util.sql.SqlPreparedStatementBuilder
import org.springframework.stereotype.Repository

@Repository
class CpuArchitectureRepository(
    private val template: NamedParameterJdbcTemplate,
    private val sqlPreparedStatementBuilder: SqlPreparedStatementBuilder
) {

    fun findAll(): List<String> {

        val list: List<CpuArchitecture> = template.query(
                sqlPreparedStatementBuilder.selectAll("cpu_architecture"), CpuArchitectureMapper())

        val transform: (CpuArchitecture) -> String = {it.name}

        return list.map(transform);
    }

}