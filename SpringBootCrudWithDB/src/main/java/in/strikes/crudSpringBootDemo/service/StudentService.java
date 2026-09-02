package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    private  StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        System.out.println("Inside Student Service - Create");
        Student studentResp = studentRepository.save(studentReq);
        System.out.println("Exiting Student Service - Create");
        return studentResp;
    }

    public List<Student> getAllStudents() {
        System.out.println("Inside Student Service - Get All");
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        System.out.println("Inside Student Service - Get By ID");
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Long id, Student studentReq) {
        System.out.println("Inside Student Service - Update");
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        // Update fields
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());
        student.setAge(studentReq.getAge());
        student.setRollNo(studentReq.getRollNo());


        // Save updated entity
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        System.out.println("Inside Student Service - Delete");
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}