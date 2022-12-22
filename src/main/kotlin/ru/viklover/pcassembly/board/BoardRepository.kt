package ru.viklover.pcassembly.board

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : CrudRepository<Board, Long>