package com.crud.repo;

import org.springframework.data.repository.CrudRepository;

import com.crud.enty.User;

public interface UserRepo extends CrudRepository<User, Long> {

}
