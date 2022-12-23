package ru.viklover.pcassembly.board

import org.springframework.stereotype.Service

import ru.viklover.pcassembly.cpu.architecture.CpuArchitectureService
import ru.viklover.pcassembly.ram.type.RamTypeService
import ru.viklover.pcassembly.util.IdService

@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val cpuArchitectureService: CpuArchitectureService,
    private val ramTypeService: RamTypeService,
    private val idService: IdService
) {

    fun create(boardDto: BoardDto): BoardDto {

        val partId = getLastPartId() + 1

        val newBoard = Board(
                id = idService.createIdByCpuArchitectureAndRamType(
                        cpuArchitectureService.findIdByName(boardDto.cpuArchitecture),
                        ramTypeService.findIdByName(boardDto.ramType),
                        partId
                ),
                name = boardDto.name,
                ramSlots = boardDto.ramSlots
        )

        newBoard.isNew = true

        boardRepository.save(newBoard)

        return BoardDto (
                partId = partId,
                name = boardDto.name,
                cpuArchitecture = boardDto.cpuArchitecture,
                ramType = boardDto.ramType,
                ramSlots = boardDto.ramSlots
        )
    }

    fun update(boardDto: BoardDto): BoardDto {

        val board = boardRepository.findByPartId(boardDto.partId)

        if (cpuArchitectureService.findById(idService.getCpuArchitectureFromId(board.id)) != boardDto.cpuArchitecture ||
                ramTypeService.findById(idService.getRamTypeFromId(board.id)) != boardDto.ramType) {

            board.id = idService.createIdByCpuArchitectureAndRamType(
                    cpuArchitectureService.findIdByName(boardDto.cpuArchitecture),
                    ramTypeService.findIdByName(boardDto.ramType),
                    boardDto.partId
            )

            boardRepository.updateIdByPartId(board.id, boardDto.partId)
        }

        board.name = boardDto.name
        board.ramSlots = boardDto.ramSlots

        boardRepository.save(board)

        return boardDto
    }

    fun findAll(): List<BoardDto> {
        return boardRepository.findAll().map {
            return@map BoardDto(
                    partId = idService.getIdPartFromId(it.id),
                    name = it.name,
                    cpuArchitecture = cpuArchitectureService.findById(
                            idService.getCpuArchitectureFromId(it.id)),
                    ramType = ramTypeService.findById(
                            idService.getRamTypeFromId(it.id)
                    ),
                    ramSlots = it.ramSlots
            )
        };
    }

    fun getLastPartId(): Int {
        return boardRepository.getLastPartId() ?: 0
    }
}