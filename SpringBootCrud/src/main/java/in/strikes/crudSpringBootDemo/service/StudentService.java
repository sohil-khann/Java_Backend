package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        System.out.println("Inside Student Service - Create");
        Student studentResp = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student Service - Create");
        return studentResp;
    }

    public List<Student> getAllStudents() {
        System.out.println("Inside Student Service - Get All");
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        System.out.println("Inside Student Service - Get By ID");
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student studentReq) {
        System.out.println("Inside Student Service - Update");
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        return studentRepository.updateStudent(id, studentReq);
    }

    public void deleteStudent(Long id) {
        System.out.println("Inside Student Service - Delete");
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteStudent(id);
    }
}