package ru.viklover.pcassembly.assembly

import org.springframework.stereotype.Service
import ru.viklover.pcassembly.assembly.dto.AssemblyDto

import ru.viklover.pcassembly.assembly.dto.NewAssemblyDto
import ru.viklover.pcassembly.assembly.dto.UpdateAssemblyDto
import ru.viklover.pcassembly.assembly.ram.AssemblyRamCombinationService
import ru.viklover.pcassembly.board.BoardRepository
import ru.viklover.pcassembly.board.BoardService
import ru.viklover.pcassembly.cpu.CpuRepository
import ru.viklover.pcassembly.cpu.CpuService

@Service
class AssemblyService(
    val assemblyRepository: AssemblyRepository,
    val assemblyRamCombinationService: AssemblyRamCombinationService,
    val cpuRepository: CpuRepository,
    val cpuService: CpuService,
    val boardService: BoardService,
    val boardRepository: BoardRepository
) {

    fun findAll(): List<AssemblyDto> {
        return assemblyRepository.findAll().map {
            toAssemblyDto(it)
        }
    }

    fun create(newAssemblyDto: NewAssemblyDto): AssemblyDto {

        val newAssembly = Assembly(
            id = null,
            name = newAssemblyDto.name,
            cpuId = cpuRepository.findByPartId(newAssemblyDto.cpuId).id,
            boardId = boardRepository.findByPartId(newAssemblyDto.boardId).id
        )

        val assembly = assemblyRepository.save(newAssembly)

        assemblyRamCombinationService.createFromList(assembly.id, newAssemblyDto.ram)

        return toAssemblyDto(assembly)
    }

    fun update(updateAssemblyDto: UpdateAssemblyDto): AssemblyDto {

        val assembly = Assembly(
                id = updateAssemblyDto.id,
                name = updateAssemblyDto.name,
                cpuId = cpuRepository.findByPartId(updateAssemblyDto.cpuId).id,
                boardId = boardRepository.findByPartId(updateAssemblyDto.boardId).id
        )

        val updatedAssembly = assemblyRepository.save(assembly)

        assemblyRamCombinationService.deleteAllByAssemblyId(updateAssemblyDto.id)
        assemblyRamCombinationService.createFromList(assembly.id, updateAssemblyDto.ram)

        return toAssemblyDto(updatedAssembly)
    }

    fun deleteById(assemblyId: Int) {
        assemblyRepository.deleteById(assemblyId)
    }

    fun toAssemblyDto(assembly: Assembly): AssemblyDto {
        return AssemblyDto(
                id = assembly.id!!,
                name = assembly.name,
                cpu = cpuService.findById(assembly.cpuId).get(),
                board = boardService.findById(assembly.boardId).get(),
                ramCombination = assemblyRamCombinationService.findByAssemblyId(assembly.id)
        )
    }
}