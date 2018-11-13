package com.shariqx.springboot.controller

import java.lang.Iterable
import java.util

import com.shariqx.springboot.entity.StudentEntity
import com.shariqx.springboot.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/student"))
class RequestController(@Autowired m_studentService: StudentService) {
    
    
    @GetMapping(path = Array("/"))
    def getStudents(): Iterable[StudentEntity] = {
        m_studentService.findAllStudents()
    }
    
    @GetMapping(path = Array("/{studentname}/{studentclass}"))
    def getStudentByNameAndCourse(@PathVariable("studentname") a_studentName: String,
                                  @PathVariable("studentclass") a_studentCourse: String): util.List[StudentEntity] = {
        m_studentService.findByStudentNameAndClass(a_studentName, a_studentCourse)
    }
    
    @GetMapping(path = Array("/{studentId}"))
    def getStudentById(@PathVariable("studentId") a_studentId: Int): StudentEntity = {
        m_studentService.findByStudentId(a_studentId)
    }
}
