package com.shariqx.springboot.repository;

import com.shariqx.springboot.entity.ApplicationUser;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
    @AllowFiltering
    ApplicationUser findByUsername(String username);
}