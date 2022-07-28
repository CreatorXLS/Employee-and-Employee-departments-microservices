package com.microservices.departmentservices.service;

import com.microservices.departmentservices.entity.Department;
import com.microservices.departmentservices.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside the save department service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId){
        log.info("Inside the find department by id service");
        return departmentRepository.findByDepartmentId(departmentId);
    }

}
