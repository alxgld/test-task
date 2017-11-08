package com.gladunalexander.test_task.controllers;

import com.gladunalexander.test_task.domain.User;
import com.gladunalexander.test_task.domain.converter.PropertyConverter;
import com.gladunalexander.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public void updateUserName(@PathVariable int id, @RequestBody PropertyConverter converter){
        userService.updateName(converter.getName(), id);
    }
}
