package com.gladunalexander.test_task.service;

import com.gladunalexander.test_task.domain.Company;
import com.gladunalexander.test_task.domain.Department;

/**
 * Service layer for {@link com.gladunalexander.test_task.repositories.CompanyRepository}
 *
 * Created by Alexander Gladun on 07/11/2017.
 */
public interface CompanyService {

    Iterable<Company> getAll();

    Company add(Company company);

    void delete(int id);

    void updateName(String name, int id);

    void addDepartment(Department department, int companyId);
}
