package com.shariqx.springboot.entity

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.{Column, PrimaryKeyColumn, Table}

import scala.beans.BeanProperty

@Table("user")
class ApplicationUser {

    @BeanProperty
    @PrimaryKeyColumn(name = "userid", `type` = PrimaryKeyType.PARTITIONED)
    var userId: Int = _
    
    @BeanProperty
    @Column("name")
    var username: String = _
   
    @BeanProperty
    var password: String = _
}
