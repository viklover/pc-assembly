package ru.viklover.pcassembly.board

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/boards")
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping
    fun create(@RequestBody board: Board): Board {
        return boardService.create(board)
    }

    @PutMapping
    fun update(@RequestBody board: Board): Board {
        return boardService.update(board)
    }

    @GetMapping
    fun getAll(): List<Board> {
        return boardService.findAll()
    }
}