package ru.viklover.pcassembly.cpu

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import ru.viklover.pcassembly.cpu.architecture.CpuArchitectureService

@RestController
@CrossOrigin
@RequestMapping("/cpu")
class CpuController(
    val cpuService: CpuService,
    val cpuArchitectureService: CpuArchitectureService
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
    fun findAll(): MutableIterable<Cpu> {
        return cpuService.findAll()
    }

    @GetMapping("architecture")
    fun getAllArchitectures(): List<String> {
        return cpuArchitectureService.findAll();
    }
}