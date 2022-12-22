package ru.viklover.pcassembly.board

import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    fun create(board: Board): Board {
        return boardRepository.save(board)
    }

    fun update(board: Board): Board {
        return boardRepository.save(board)
    }

    fun findAll(): MutableIterable<Board> {
        return boardRepository.findAll();
    }
}