package ru.viklover.pcassembly.ram

import org.springframework.web.bind.annotation.*

import ru.viklover.pcassembly.ram.type.RamTypeService

@RestController
@CrossOrigin
@RequestMapping("/ram")
class RamController(
    val ramService: RamService,
    val ramTypeService: RamTypeService
) {

    @PostMapping
    fun create(@RequestBody ram: RamDto): RamDto {
        return ramService.create(ram)
    }

    @PutMapping
    fun update(@RequestBody ram: RamDto): RamDto {
        return ramService.update(ram)
    }

    @GetMapping
    fun findAll(@RequestParam(name = "type", defaultValue = "") type: String): List<RamDto> {

        if (type != "") {
            return ramService.findByType(type)
        }

        return ramService.findAll()
    }

    @GetMapping("types")
    fun getAllTypes(): List<String> {
        return ramTypeService.findAll();
    }
}