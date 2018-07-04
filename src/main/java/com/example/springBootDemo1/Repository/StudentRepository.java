package com.example.springBootDemo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootDemo1.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
