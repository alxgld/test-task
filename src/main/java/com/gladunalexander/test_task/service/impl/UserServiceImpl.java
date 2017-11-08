package com.gladunalexander.test_task.service.impl;

import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.domain.User;
import com.gladunalexander.test_task.exceptions.DepartmentNotFoundException;
import com.gladunalexander.test_task.exceptions.UserNotFoundException;
import com.gladunalexander.test_task.repositories.DepartmentRepository;
import com.gladunalexander.test_task.repositories.UserRepository;
import com.gladunalexander.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Custom implementation for {@link UserService}
 *
 * Created by Alexander Gladun on 07/11/2017.
 */

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        checkIfUserNotExists(id);
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public void updateName(String name, int userId) {
        checkIfUserNotExists(userId);
        userRepository.updateName(name, userId);
    }

    @Override
    public List<User> getUsersByPositionAndDepartment(String positionName, int departmentId) {
       Department department = departmentRepository.findOne(departmentId)
               .orElseThrow(DepartmentNotFoundException::new);
           return department.getUsers().stream()
                   .filter(user -> user.getPosition().name().equalsIgnoreCase(positionName))
                   .collect(Collectors.toList());
    }

    private void checkIfUserNotExists(int id){
         userRepository.findOne(id)
                 .orElseThrow(UserNotFoundException::new);
    }
}
