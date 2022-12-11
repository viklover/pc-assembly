package ru.viklover.pcassembly.processor

import org.springframework.jdbc.core.RowMapper
import ru.viklover.pcassembly.memory.MemoryType
import java.sql.ResultSet

class ProcessorRowMapper : RowMapper<Processor> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Processor {

        return Processor(
                name = rs.getString("name"),
                architecture = ProcessorArchitecture.valueOf(rs.getString("architecture")),
                speed = rs.getInt("speed"),
                memoryType = MemoryType.valueOf(rs.getString("memory_type")),
                maxMemoryCapacity = rs.getInt("max_memory_capacity")
        )
    }

}