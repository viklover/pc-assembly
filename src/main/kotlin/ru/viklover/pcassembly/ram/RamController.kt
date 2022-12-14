package ru.viklover.pcassembly.ram

import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/ram")
class RamController(
    val ramService: RamService
) {

    @PostMapping
    fun create(@RequestBody ram: Ram): Ram {
        return ramService.create(ram)
    }

    @PutMapping
    fun update(@RequestBody ram: Ram): Ram {
        return ramService.update(ram)
    }

    @GetMapping
    fun getAll(): List<Ram> {
        return ramService.findAll()
    }
}