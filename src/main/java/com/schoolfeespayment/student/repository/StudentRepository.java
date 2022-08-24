package com.schoolfeespayment.student.repository;

import com.schoolfeespayment.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository <Student, Long>{

}
