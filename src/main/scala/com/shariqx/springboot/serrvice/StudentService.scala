package com.shariqx.springboot.serrvice

import java.lang.Iterable
import java.util

import com.shariqx.springboot.entity.StudentEntity
import com.shariqx.springboot.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentService(@Autowired val m_studentRepository: StudentRepository) {
    
    
    def findByStudentId(a_id: Int): StudentEntity = {
        m_studentRepository.findByStudentId(a_id)
    }
    
    def findAllStudents(): Iterable[StudentEntity] = {
        m_studentRepository.findAll()
    }
    
    def findByStudentNameAndClass(a_name: String, a_course: String): util.List[StudentEntity] = {
        m_studentRepository.findByStudentNameAndStudentClass(a_name, a_course)
    }
}
