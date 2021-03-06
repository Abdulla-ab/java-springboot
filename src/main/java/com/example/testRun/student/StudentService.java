package com.example.testRun.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByFirstname(student.getFirstname());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("first name taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists"
            );
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Integer studentId, String firstname, String lastname) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exist"
        ) );
        if (firstname != null && firstname.length() > 0 && !Objects.equals(student.getFirstname(), firstname)){
            student.setFirstname(firstname);
        }

        if (lastname != null && lastname.length() > 0 && !Objects.equals(student.getLastname(), lastname)){
            student.setLastname(lastname);
        }

    }
}
