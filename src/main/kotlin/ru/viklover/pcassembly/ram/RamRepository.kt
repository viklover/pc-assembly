package ru.viklover.pcassembly.ram

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RamRepository : CrudRepository<Ram, Int> {

    @Query("select (id & 0xFF) as 'id' from ram order by 1 desc limit 1")
    fun getLastPartId(): Int?

    @Query("select * from ram where (id & 0xFF) = :id limit 1")
    fun findByPartId(id: Int): Optional<Ram>

    @Modifying
    @Query("update ram set id = :id where (id & 0xFF) = :partId")
    fun updateIdByPartId(id: Int, partId: Int)
}