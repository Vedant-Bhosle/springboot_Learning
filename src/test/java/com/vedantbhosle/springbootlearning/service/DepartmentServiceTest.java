package com.vedantbhosle.springbootlearning.service;

import com.vedantbhosle.springbootlearning.entity.Department;
import com.vedantbhosle.springbootlearning.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
//mocking ///////////@BeforeEachMocking in Spring Boot refers to the practice of creating simulated or "mock" objects to replace real objects or dependencies during unit testing. The primary goal of mocking is to isolate the code under test and focus specifically on the behavior of the unit being tested. By using mock objects, you can control the interactions with dependencies and simulate various scenarios, ensuring that the unit being tested functions as expected in different conditions.
   @MockBean //is used to create mock instances of beans and replace the actual beans in the application context during testing. This annotation is often used in integration tests to isolate certain components or dependencies, allowing you to control their behavior for the purpose of testing.
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("IT").departmentId(1L).departmentAddress("Bangalore").departmentCode("It-08").build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);//so when you call particular method for name It .it reutns department

    }
////
    //Testing fetch department by name
    @Test
    @DisplayName("Get Data based on Valid Department Name")
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
        // Manually inject the mock repository into the service
//        departmentService.setDepartmentRepository(departmentRepository);


        Department found=departmentService.fetchDepartmentByName(departmentName);
         assertNotNull(found);
        assertEquals(departmentName,found.getDepartmentName());

    }
}