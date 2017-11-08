package com.gladunalexander.test_task.service.impl;

import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.domain.User;
import com.gladunalexander.test_task.exceptions.DepartmentNotFoundException;
import com.gladunalexander.test_task.repositories.DepartmentRepository;
import com.gladunalexander.test_task.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Custom implementation for {@link DepartmentService}
 *
 * Created by Alexander Gladun on 07/11/2017.
 */

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void delete(int id) {
        checkIfDepartmentNotExists(id);
        departmentRepository.delete(id);
    }

    @Override
    @Transactional
    public void addUsers(int departmentId, List<User> users) {
        Department department = checkIfDepartmentNotExists(departmentId);
        users.forEach(user -> {
            department.getUsers().add(user);
            user.setCompany(department.getCompany());
            user.setDepartments(Arrays.asList(department));
        });
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getByUsers(List<Integer> users) {
        Iterable<Department> departments = departmentRepository.findAll();
        List<Department> allMatchingDepartments = new ArrayList<>();
        departments.forEach(department -> {
            Set<Integer> ids = new HashSet<>();
            department.getUsers().forEach(user -> ids.add(user.getId()));
            if (ids.containsAll(users)){
                allMatchingDepartments.add(department);
            }
        });
        return allMatchingDepartments;
    }

    private Department checkIfDepartmentNotExists(int id) {
       return departmentRepository.findOne(id)
                .orElseThrow(DepartmentNotFoundException::new);
    }
}
