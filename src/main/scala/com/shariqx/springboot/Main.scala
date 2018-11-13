package com.shariqx.springboot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = Array("com.shariqx"))
//@EnableAutoConfiguration(exclude = Array(classOf[CassandraDataAutoConfiguration]))
class Application {
    
    import org.springframework.context.annotation.Bean
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
    
    @Bean def bCryptPasswordEncoder = new BCryptPasswordEncoder
    
    import org.springframework.context.annotation.Bean
    import org.springframework.web.servlet.config.annotation.{CorsRegistry, WebMvcConfigurer, WebMvcConfigurerAdapter}
    
    @Bean def corsConfigurer: WebMvcConfigurer = new WebMvcConfigurerAdapter() {
        override def addCorsMappings(registry: CorsRegistry): Unit = {
            registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE")
        }
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        SpringApplication.run(classOf[Application])
    }
}
