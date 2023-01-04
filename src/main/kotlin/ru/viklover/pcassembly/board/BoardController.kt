package ru.viklover.pcassembly.board

import com.fasterxml.jackson.databind.JsonSerializer.None
import jakarta.websocket.server.PathParam
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.web.bind.annotation.*
import javax.annotation.Nullable

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
    fun findAll(@RequestParam(name = "cpu_architecture", defaultValue = "") cpuArchitecture: String,
                @RequestParam(name = "ram_type", defaultValue = "") ramType: String): List<BoardDto> {

        if (cpuArchitecture != "" && ramType != "") {
            return boardService.findByCpuArchitectureAndRamType(cpuArchitecture, ramType)
        }

        return boardService.findAll()
    }
}