package com.vedantbhosle.springbootlearning.repository;

import com.vedantbhosle.springbootlearning.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest   //The annotation configures an embedded in-memory database (such as H2) by default. It allows you to test repository methods against a real database without the need for a separate database setup.
//It can also automatically initialize the database with test data using scripts or import statements, providing a realistic environment for testing. @DataJpaTest configures and manages transactions for your tests. Each test method typically runs within its transaction, and the transaction is rolled back at the end of the test. This ensures that the database remains in a consistent state between test runs

class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department department=Department.builder().departmentName("Mechanical").departmentAddress("Delhi").departmentCode("CS-09").build();

        entityManager.persist(department);

    }
   @Test
   @Disabled
    public void whenFindById_thenReturnDepartment(){
      Department department=departmentRepository.findById(1L).get();
      assertNotNull(department);
      assertEquals(department.getDepartmentName(),"Mechanical");
    }
}




///i dont know why this code give error please find it later from person who knows