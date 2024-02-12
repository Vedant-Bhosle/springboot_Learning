package com.vedantbhosle.springbootlearning.controller;

import com.vedantbhosle.springbootlearning.entity.Department;
import com.vedantbhosle.springbootlearning.error.DepartmentNotFoundException;
import com.vedantbhosle.springbootlearning.service.DepartmentService;
import com.vedantbhosle.springbootlearning.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.logging.Logger;

@RestController
public class DepartmentController {
     @Autowired //autowired the perticular object that you have in a spring container
    private DepartmentService departmentService;

//       private final Logger LOGGER= (Logger) LoggerFactory.getLogger(DepartmentController.class);

     @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){ //here we telling spring whatever data you get in the body which in json format convert into Department format
        //@valid is used when some do request it validate the data in the body according to the annotations written in department entity file like notBlank ,maxlength,minlenth etc...
         //now we call service layer for buisness logic
         //after buisness logic we can call repository layer to save the data
//         DepartmentService service=new DepartmentServiceImpl(); we dont want to create object explicitlly by our own it is the work of spring all methods calsses are stored in container we can request whatever we want from spring
//      LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
//        LOGGER.info("Inside fetchDepartments of DepartmentController");
           return departmentService.fetchDepartments();
    }
     @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException { //this pathVariable is like params and we get this using syntax as used
//         LOGGER.info("Inside fetchDepartmentById of DepartmentController");

         return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
//        LOGGER.info("Inside deleteDepartmentById of DepartmentController");

        departmentService.deleteDepartmentById(departmentId);
          return "Department Deleted";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id")Long departmentId,@RequestBody Department department){
         return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name")String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
