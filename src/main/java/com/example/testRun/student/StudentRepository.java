package com.example.testRun.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findStudentByFirstname(String firstname);

//    @Query("SELECT s FROM Student WHERE s.email = ?1")
//    Optional<Student> findStudentByFirstname(String firstname);
}
