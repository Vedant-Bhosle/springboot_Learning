package com.vedantbhosle.springbootlearning.entity;

import jakarta.persistence.*;
//import javax.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data //it is used instead of all getter setters it is automatically generates it when coplied
@NoArgsConstructor //to create default constructor
@AllArgsConstructor //for parameterised constructor
@Builder //for all this entity builder pattern is implemented
//all  of the above annotations are mandatory to generate all getter setter constructors and build the jar file of this
//@Table(name = "department")
public class Department {
    @Id //this is to declare primary key which is departmentid
    @GeneratedValue(strategy = GenerationType.AUTO) //this is to generate auto
    private Long departmentId;
    @NotBlank(message = "Please Add Department Name")
//    @Length(min = 1,max = 5,message = "length should be more than 1 and <= 5")
//    @Email
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

//    public Long getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Long departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public String getDepartmentAddress() {
//        return departmentAddress;
//    }
//
//    public void setDepartmentAddress(String departmentAddress) {
//        this.departmentAddress = departmentAddress;
//    }
//
//    public String getDepartmentCode() {
//        return departmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        this.departmentCode = departmentCode;
//    }
//
//    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
//        this.departmentAddress = departmentAddress;
//        this.departmentCode = departmentCode;
//    }
//
//    public Department(){
//
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", departmentAddress='" + departmentAddress + '\'' +
//                ", departmentCode='" + departmentCode + '\'' +
//                '}';
//    }
}
