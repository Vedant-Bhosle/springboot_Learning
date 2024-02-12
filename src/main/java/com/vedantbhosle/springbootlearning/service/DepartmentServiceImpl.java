package com.vedantbhosle.springbootlearning.service;

import com.vedantbhosle.springbootlearning.entity.Department;
import com.vedantbhosle.springbootlearning.error.DepartmentNotFoundException;
import com.vedantbhosle.springbootlearning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
 private DepartmentRepository departmentRepository;

    //this is added becasuse error getting while mocking
/*    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }*/
/////////

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department); //here we pass department entity
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll(); //findAll method return all department in a list
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
//        return  departmentRepository.findById(departmentId).get(); //.get(): This method is called on the result of findById(departmentId). In this context, it is used to retrieve the actual entity object from the Optional<T> returned by findById. The get() method is used when you are certain that the Optional contains a non-null value
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department depDb=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDb);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
//there no default method in jpaRepository to fetch by name, so we have to explicitly defined in departmentRepository
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
