package com.thbs.UserService.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thbs.UserService.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
