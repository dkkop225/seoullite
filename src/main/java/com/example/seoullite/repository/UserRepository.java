package com.example.seoullite.repository;

import com.example.seoullite.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
