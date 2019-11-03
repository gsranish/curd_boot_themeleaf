package com.gsr.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gsr.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
