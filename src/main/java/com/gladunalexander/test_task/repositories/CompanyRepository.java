package com.gladunalexander.test_task.repositories;

import com.gladunalexander.test_task.domain.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by Alexander Gladun on 07/11/2017.
 */

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Modifying
    @Query("UPDATE Company c SET c.name =:name WHERE c.id =:id")
    void updateName(@Param("name") String name, @Param("id") int id);

    Optional<Company> findOne(int id);
}
