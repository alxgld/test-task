package com.gladunalexander.test_task.service;

import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.domain.User;

import java.util.List;

/**
 * Service layer for {@link com.gladunalexander.test_task.repositories.DepartmentRepository}
 *
 * Created by Alexander Gladun on 07/11/2017.
 */

public interface DepartmentService {

    Department add(Department department);

    void delete(int id);

    void addUsers(int departmentId, List<User> users);

    List<Department> getByUsers(List<Integer> users);



}
