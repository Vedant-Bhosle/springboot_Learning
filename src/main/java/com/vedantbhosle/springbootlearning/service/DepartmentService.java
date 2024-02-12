package com.vedantbhosle.springbootlearning.service;

import com.vedantbhosle.springbootlearning.entity.Department;
import com.vedantbhosle.springbootlearning.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
  public  Department saveDepartment(Department department);

   public List<Department> fetchDepartments();

  public  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  public  void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
