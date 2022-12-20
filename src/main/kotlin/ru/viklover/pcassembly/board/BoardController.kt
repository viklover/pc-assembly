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
    fun findAll(): List<Board> {
        return boardService.findAll()
    }

    @GetMapping("fields")
    fun getModelFields(): List<String> {
        return boardService.getModelFields()
    }
}