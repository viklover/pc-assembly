package ru.viklover.pcassembly.processor

import org.springframework.stereotype.Service

@Service
class ProcessorService(
    private val processorRepository: ProcessorRepository
) {

    fun create(processor: Processor): Processor {

        return Processor(
                name = processorRepository.create(processor),
                architecture = processor.architecture,
                speed = processor.speed,
                memoryType = processor.memoryType,
                maxMemoryCapacity = processor.maxMemoryCapacity
        )
    }

    fun update(processor: Processor): Processor {
        return processorRepository.update(processor)
    }

    fun findAll(): List<Processor> {
        return processorRepository.findAll();
    }
}
