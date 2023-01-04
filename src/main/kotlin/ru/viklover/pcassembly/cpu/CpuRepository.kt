package ru.viklover.pcassembly.cpu

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CpuRepository : CrudRepository<Cpu, Int> {

    @Query("select (id & 0xFF) as 'id' from cpu order by 1 desc limit 1")
    fun getLastPartId(): Int?

    @Query("select * from cpu where (id & 0xFF) = :id limit 1")
    fun findByPartId(id: Int): Cpu

    @Modifying
    @Query("update cpu set id = :id where (id & 0xFF) = :partId")
    fun updateIdByPartId(id: Int, partId: Int)
}