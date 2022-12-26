package ru.viklover.pcassembly.board

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.viklover.pcassembly.cpu.architecture.CpuArchitecture

@Repository
interface BoardRepository : CrudRepository<Board, Int> {

    @Query("select (id & 0xFF) as 'id' from board order by 1 desc limit 1")
    fun getLastPartId(): Int?

    @Query("select * from board where (id & 0xFF) = :id limit 1")
    fun findByPartId(id: Int): Board

    @Query("select * from board where (id >> 12) = :cpuArchitectureId AND ((id >> 8) & 0x0F) = :ramTypeId")
    fun findByCpuArchitectureAndRamType(cpuArchitectureId: Int, ramTypeId: Int): List<Board>

    @Modifying
    @Query("update board set id = :id where (id & 0xFF) = :partId")
    fun updateIdByPartId(id: Int, partId: Int)
}