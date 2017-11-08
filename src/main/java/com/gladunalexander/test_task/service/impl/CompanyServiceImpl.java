package com.gladunalexander.test_task.service.impl;

import com.gladunalexander.test_task.domain.Company;
import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.exceptions.CompanyNotFoundException;
import com.gladunalexander.test_task.repositories.CompanyRepository;
import com.gladunalexander.test_task.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Custom implementation for {@link CompanyService}
 *
 * Created by Alexander Gladun on 07/11/2017.
 */

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Iterable<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public Company add(Company company) {
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public void delete(int id) {
        checkIfCompanyNotExists(id);
        companyRepository.delete(id);
    }

    @Override
    @Transactional
    public void updateName(String name, int id) {
        checkIfCompanyNotExists(id);
        companyRepository.updateName(name, id);
    }

    @Override
    @Transactional
    public void addDepartment(Department department, int companyId) {
        Company company = companyRepository.findOne(companyId)
                .orElseThrow(CompanyNotFoundException::new);
        department.setCompany(company);
        company.getDepartments().add(department);
        companyRepository.save(company);
    }

    private Company checkIfCompanyNotExists(int id){
        return companyRepository.findOne(id)
                .orElseThrow(CompanyNotFoundException::new);
    }
}
