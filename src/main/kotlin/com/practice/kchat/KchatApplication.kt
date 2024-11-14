package com.practice.kchat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KchatApplication

fun main(args: Array<String>) {
	runApplication<KchatApplication>(*args)
}
