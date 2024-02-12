package com.vedantbhosle.springbootlearning.repository;

import com.vedantbhosle.springbootlearning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    //IN jpaRespository we have to pass entity and type of primary key

    public Department findByDepartmentName(String departmentName);
    //only we have to do this to make a custom method from which we get a department by name
    //only take care while writing name of method it is findBy{name of field from which you have to find document like "departmentName" only write first char of field is capital so that whole method name follow camelcase convention }

    public Department findByDepartmentNameIgnoreCase(String departmentName); //this method is same as above only in addition it ignores case by adding only "IgnoreCase" in method name
//    https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html see documents for more methods
}
