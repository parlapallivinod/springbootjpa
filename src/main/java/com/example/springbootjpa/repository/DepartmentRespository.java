package com.example.springbootjpa.repository;

import com.example.springbootjpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Long> {
}
