package com.osmbiradar.journals.service;

import com.osmbiradar.journals.entity.Users;
import com.osmbiradar.journals.repository.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;

    // Dependency injection through constructor
    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }


    @Override
    public Users createUser(Users user) {


        return usersRepository.save(user);
    }

    @Override
    public Users getUserById(ObjectId id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users updateUser(Users user) {

        Users newUser = usersRepository.findByUsername(user.getUsername()).orElse(null);
        assert newUser!=null;
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        return usersRepository.save(newUser);
    }

    @Override
    public void deleteUser(ObjectId id) {
     usersRepository.deleteById(id);
    }
}
