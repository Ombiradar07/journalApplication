package com.osmbiradar.journals.service;

import com.osmbiradar.journals.entity.Users;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    Users createUser(Users user);
    Users getUserById(ObjectId id);
    List<Users> getAllUsers();
    Users updateUser(Users user);
    void deleteUser(ObjectId id);

}
