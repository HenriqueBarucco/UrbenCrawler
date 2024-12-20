package com.henriquebarucco.urben

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
class UrbenCrawlerApplication

fun main(args: Array<String>) {
    runApplication<UrbenCrawlerApplication>(*args)
}
