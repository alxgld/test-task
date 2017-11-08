package com.gladunalexander.test_task.repositories;

import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Alexander Gladun on 07/11/2017.
 */
public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    Optional<Department> findOne(int id);
}
