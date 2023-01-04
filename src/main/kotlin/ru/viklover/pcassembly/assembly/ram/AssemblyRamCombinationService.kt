package ru.viklover.pcassembly.assembly.ram

import org.springframework.stereotype.Service

import ru.viklover.pcassembly.ram.RamDto
import ru.viklover.pcassembly.ram.RamRepository
import ru.viklover.pcassembly.ram.RamService

@Service
class AssemblyRamCombinationService(
    val assemblyRamCombinationRepository: AssemblyRamCombinationRepository,
    val ramRepository: RamRepository,
    val ramService: RamService
) {

    fun analyzeRam(ram: List<Int>): MutableMap<Int, Int> {

        val map = mutableMapOf<Int, Int>()

        ram.forEach {
            if (!map.containsKey(it))
                map[it] = 1
            else
                map[it] = map[it]!! + 1
        }

        return map
    }

    fun create(assemblyRamCombination: AssemblyRamCombination): AssemblyRamCombination {
        return assemblyRamCombinationRepository.save(assemblyRamCombination)
    }

    fun createFromList(assemblyId: Int?, ram: List<Int>) {
        analyzeRam(ram).forEach {
            create(
                AssemblyRamCombination(
                    id = null,
                    assemblyId = assemblyId,
                    ramId = ramRepository.findByPartId(it.key).id,
                    count = it.value
                )
            )
        }
    }

    fun deleteAllByAssemblyId(assemblyId: Int) {
        assemblyRamCombinationRepository.deleteAllByAssemblyId(assemblyId)
    }

    fun findByAssemblyId(id: Int?): List<RamDto> {

        val ramArray = arrayListOf<RamDto>()

        assemblyRamCombinationRepository.findByAssemblyId(id).forEach {

            for (i in 1..it.count) {
                it.ramId?.let { it1 -> ramService.findById(it1)?.get() }?.let { it2 -> ramArray.add(it2) }
            }
        }

        return ramArray
    }
}