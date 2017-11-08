package com.gladunalexander.test_task.repositories;

import com.gladunalexander.test_task.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

/**
 * Created by Alexander Gladun on 07/11/2017.
 */

public interface UserRepository extends CrudRepository<User, Integer> {

    @Modifying
    @Query("UPDATE User u SET u.firstName =:name WHERE u.id =:id")
    void updateName(@Param("name") String name, @Param("id") int id);

    Optional<User> findOne(int id);
}
