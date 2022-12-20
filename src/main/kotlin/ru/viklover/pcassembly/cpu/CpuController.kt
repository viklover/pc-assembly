package ru.viklover.pcassembly.cpu

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import ru.viklover.pcassembly.cpu.architecture.CpuArchitectureRepository

@RestController
@CrossOrigin
@RequestMapping("/cpu")
class CpuController(
    val cpuService: CpuService,
    val cpuArchitectureRepository: CpuArchitectureRepository
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
    fun findAll(): List<Cpu> {
        return cpuService.findAll()
    }

    @GetMapping("fields")
    fun getModelFields(): List<String> {
        return cpuService.getModelFields()
    }

    @GetMapping("architecture")
    fun getAllArchitectures(): List<String> {
        return cpuArchitectureRepository.findAll();
    }
}