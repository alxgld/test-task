package com.gladunalexander.test_task.service;

import com.gladunalexander.test_task.domain.User;

import java.util.List;

/**
 * Service layer for {@link com.gladunalexander.test_task.repositories.UserRepository}
 *
 * Created by Alexander Gladun on 07/11/2017.
 */
public interface UserService {

    User addUser(User user);

    void deleteUser(int id);

    void updateName(String name, int userId);

    List<User> getUsersByPositionAndDepartment(String positionName, int departmentId);
}
