package com.henriquebarucco.urben

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UrbenCrawlerApplication

fun main(args: Array<String>) {
    runApplication<UrbenCrawlerApplication>(*args)
}
