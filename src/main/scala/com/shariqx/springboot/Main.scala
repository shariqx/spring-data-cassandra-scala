package com.shariqx.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = Array("com.shariqx"))
//@EnableAutoConfiguration(exclude = Array(classOf[CassandraDataAutoConfiguration]))
class Application {

}

object Main {
    def main(args: Array[String]): Unit = {
        SpringApplication.run(classOf[Application])
    }
}
