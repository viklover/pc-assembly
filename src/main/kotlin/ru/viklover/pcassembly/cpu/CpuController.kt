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
    fun create(@RequestBody cpuDto: CpuDto): CpuDto {
        return cpuService.create(cpuDto)
    }

    @PutMapping
    fun update(@RequestBody cpu: CpuDto): CpuDto {
        return cpuService.update(cpu)
    }

    @GetMapping
    fun findAll(): List<CpuDto> {
        return cpuService.findAll()
    }

    @GetMapping("architecture")
    fun getAllArchitectures(): List<String> {
        return cpuArchitectureService.findAll();
    }
}