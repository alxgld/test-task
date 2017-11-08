package com.gladunalexander.test_task.controllers;

import com.gladunalexander.test_task.domain.Company;
import com.gladunalexander.test_task.domain.converter.PropertyConverter;
import com.gladunalexander.test_task.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Alexander Gladun on 08/11/2017.
 */

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public Iterable<Company> getAllCompanies(){
        return companyService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company){
        return companyService.add(company);
    }

    @DeleteMapping("/{id}")
    public void removeCompany(@PathVariable int id){
        companyService.delete(id);
    }

    @PatchMapping("/{id}")
    public void updateCompanyName(@PathVariable int id, @RequestBody PropertyConverter converter){
        companyService.updateName(converter.getName(), id);
    }
}
