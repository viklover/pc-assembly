package ru.viklover.pcassembly.processor

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
class ProcessController(
    val processorService: ProcessorService
) {

    @PostMapping
    fun create(@RequestBody processor: Processor): Processor {
        return processorService.create(processor)
    }

    @PutMapping
    fun update(@RequestBody processor: Processor): Processor {
        return processorService.update(processor)
    }

    @GetMapping
    fun getAll(): List<Processor> {
        return processorService.findAll()
    }
}