package ru.viklover.pcassembly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PcAssemblyApplication

fun main(args: Array<String>) {
    runApplication<PcAssemblyApplication>(*args)
}
