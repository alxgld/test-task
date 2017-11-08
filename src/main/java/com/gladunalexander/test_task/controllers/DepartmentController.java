package com.gladunalexander.test_task.controllers;

import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.domain.User;
import com.gladunalexander.test_task.service.CompanyService;
import com.gladunalexander.test_task.service.DepartmentService;
import com.gladunalexander.test_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @PostMapping("/{companyId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@PathVariable int companyId,
                              @RequestBody Department department) {
        companyService.addDepartment(department, companyId);
    }

    @DeleteMapping("/{id}")
    public void removeDepartment(@PathVariable int id) {
        departmentService.delete(id);
    }

    @GetMapping
    public List<Department> getByUsers(@RequestParam("id") List<Integer> users) {
        return departmentService.getByUsers(users);
    }


    @GetMapping("/{departmentId}/{positionName}")
    public Iterable<User> getUsersFromDepartmentByPosition(@PathVariable int departmentId,
                                                           @PathVariable String positionName) {
        return userService.getUsersByPositionAndDepartment(positionName, departmentId);
    }


    @PatchMapping("/{id}")
    public void addUsers(@PathVariable int id, @RequestBody List<User> users) {
        departmentService.addUsers(id, users);
    }
}
