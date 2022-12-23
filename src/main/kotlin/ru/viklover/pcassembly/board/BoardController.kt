package ru.viklover.pcassembly.board

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/boards")
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping
    fun create(@RequestBody board: BoardDto): BoardDto {
        return boardService.create(board)
    }

    @PutMapping
    fun update(@RequestBody board: BoardDto): BoardDto {
        return boardService.update(board)
    }

    @GetMapping
    fun findAll(): List<BoardDto> {
        return boardService.findAll()
    }
}