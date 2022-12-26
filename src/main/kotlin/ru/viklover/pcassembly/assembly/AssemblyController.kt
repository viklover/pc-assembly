package ru.viklover.pcassembly.assembly

import org.springframework.web.bind.annotation.*
import ru.viklover.pcassembly.assembly.dto.AssemblyDto
import ru.viklover.pcassembly.assembly.dto.NewAssemblyDto
import ru.viklover.pcassembly.assembly.dto.UpdateAssemblyDto
import java.net.http.HttpResponse

@RestController
@CrossOrigin
@RequestMapping("/assembly")
class AssemblyController(
    val assemblyService: AssemblyService
) {

    @GetMapping()
    fun findAll(): List<AssemblyDto> {
        return assemblyService.findAll()
    }

    @PutMapping()
    fun update(@RequestBody assembly: UpdateAssemblyDto): AssemblyDto {
        return assemblyService.update(assembly)
    }

    @DeleteMapping()
    fun delete(@RequestParam("id") assemblyId: Int) {
        assemblyService.deleteById(assemblyId)
    }


    @PostMapping()
    fun create(@RequestBody assembly: NewAssemblyDto): AssemblyDto {
        return assemblyService.create(assembly)
    }
}
