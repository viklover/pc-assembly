package ru.viklover.pcassembly.processor

import com.fasterxml.jackson.annotation.JsonProperty
import ru.viklover.pcassembly.memory.MemoryType

class Processor(
    var name: String,
    var architecture: ProcessorArchitecture,
    var speed: Int,
    @JsonProperty("memory_type") var memoryType: MemoryType,
    @JsonProperty("max_memory_capacity") var maxMemoryCapacity: Int
)
