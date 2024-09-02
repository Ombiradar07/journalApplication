package com.osmbiradar.journals.repository;

import com.osmbiradar.journals.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, ObjectId> {

   Optional<Users> findByUsername(String username);
}
