package com.gladunalexander.test_task;

import com.gladunalexander.test_task.domain.Company;
import com.gladunalexander.test_task.domain.Department;
import com.gladunalexander.test_task.domain.Position;
import com.gladunalexander.test_task.domain.User;
import com.gladunalexander.test_task.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.gladunalexander.test_task.domain")
public class TestTaskApplication {

    @Autowired
    private CompanyService companyService;

	public static void main(String[] args) {
		SpringApplication.run(TestTaskApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(){
	    return args -> populateDB();
    }

    private void populateDB() {
        Company amazon = new Company("Amazon");
        Company google = new Company("Google");
        Company microsoft = new Company("Microsoft");

        Department development = new Department("development");
        Department management = new Department("management");

        User user1 = new User("Alexander", "Matorin", LocalDate.of(1993, 10, 10));
        user1.setPosition(Position.DEVELOPER);
        user1.setCompany(amazon);

        User user2 = new User("Vladimir", "Turianin", LocalDate.of(1984, 3, 24));
        user2.setPosition(Position.DEVELOPER);
        user2.setCompany(amazon);

        User user3 = new User("Petr", "Varin", LocalDate.of(1992, 12, 12));
        user3.setPosition(Position.PM);
        user3.setCompany(amazon);

        development.setUsers(Arrays.asList(user1, user2, user3));
        development.getUsers().forEach(user -> user.setDepartments(Arrays.asList(development, management)));

        amazon.setDepartments(Arrays.asList(development, management));
        development.setCompany(amazon);
        management.setCompany(amazon);

        companyService.add(amazon);
        companyService.add(google);
        companyService.add(microsoft);
    }
}
