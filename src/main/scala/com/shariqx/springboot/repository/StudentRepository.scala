package com.shariqx.springboot.repository

import java.util

import com.shariqx.springboot.entity.StudentEntity
import org.springframework.data.cassandra.repository.AllowFiltering
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait StudentRepository extends CrudRepository[StudentEntity, Int] {
    
    def findByStudentId(id: Int): StudentEntity
    
    @AllowFiltering
    def findByStudentNameAndStudentClass(name: String, course: String): util.List[StudentEntity]
}
