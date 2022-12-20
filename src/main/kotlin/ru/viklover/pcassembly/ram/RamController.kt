package ru.viklover.pcassembly.ram

import org.springframework.web.bind.annotation.*

import ru.viklover.pcassembly.ram.type.RamTypeRepository

@RestController
@CrossOrigin
@RequestMapping("/ram")
class RamController(
    val ramService: RamService,
    val ramTypeRepository: RamTypeRepository
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
    fun findAll(): List<Ram> {
        return ramService.findAll()
    }

    @GetMapping("types")
    fun getAllTypes(): List<String> {
        return ramTypeRepository.findAll();
    }

    @GetMapping("fields")
    fun getModelFields(): List<String> {
        return ramService.getModelFields()
    }
}