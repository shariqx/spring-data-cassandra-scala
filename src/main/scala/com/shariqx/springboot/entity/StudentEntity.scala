package com.shariqx.springboot.entity

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.{Column, PrimaryKeyColumn, Table}

import scala.beans.BeanProperty

@Table("student")
class StudentEntity extends Serializable {
    @BeanProperty
    @PrimaryKeyColumn(name = "studentid", `type` = PrimaryKeyType.PARTITIONED)
    var studentId: Int = _
    @PrimaryKeyColumn(name = "studentclass", `type` = PrimaryKeyType.CLUSTERED)
    @BeanProperty
    var studentClass: String = _
    @BeanProperty
    var studentName: String = _
    @Column("ENGLISH_MARKS")
    @BeanProperty
    var englishMarks: Float = _
    @Column("MATH_MARKS")
    @BeanProperty
    var mathMarks: Float = _
    @Column("IT_MARKS")
    @BeanProperty
    var itMarks: Float = _
}
