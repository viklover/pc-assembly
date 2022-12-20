package ru.viklover.pcassembly.board

import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardRepository: BoardRepository
) {

    fun create(board: Board): Board {
        return boardRepository.create(board)
    }

    fun update(board: Board): Board {
        return boardRepository.update(board)
    }

    fun findAll(): List<Board> {
        return boardRepository.findAll();
    }

    fun getModelFields(): List<String> {
        return boardRepository.getModelFields();
    }
}