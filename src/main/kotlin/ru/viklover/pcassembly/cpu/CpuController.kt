package ru.viklover.pcassembly.cpu

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/processors")
class CpuController(
    val cpuService: CpuService
) {

    @PostMapping
    fun create(@RequestBody cpu: Cpu): Cpu {
        return cpuService.create(cpu)
    }

    @PutMapping
    fun update(@RequestBody cpu: Cpu): Cpu {
        return cpuService.update(cpu)
    }

    @GetMapping
    fun getAll(): List<Cpu> {
        return cpuService.findAll()
    }
}