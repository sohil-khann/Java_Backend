package in.strikes.crudSpringBootDemo.controller;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Inside Student Controller - Create");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting Student Controller - Create");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        System.out.println("Inside Student Controller - Get All");
        List<Student> students = studentService.getAllStudents();
        System.out.println("Exiting Student Controller - Get All");
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("/")
    public ResponseEntity<Student> getStudentById(@RequestParam Long id) {
        System.out.println("Inside Student Controller - Get By ID");
        Student student = studentService.getStudentById(id);
        if (student != null) {
            System.out.println("Exiting Student Controller - Get By ID");
            return ResponseEntity.ok(student);
        }
        System.out.println("Exiting Student Controller - Get By ID (Not Found)");
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        System.out.println("Inside Student Controller - Update");
        try {
            Student updatedStudent = studentService.updateStudent(id, student);
            System.out.println("Exiting Student Controller - Update");
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            System.out.println("Exiting Student Controller - Update (Not Found)");
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        System.out.println("Inside Student Controller - Delete");
        try {
            studentService.deleteStudent(id);
            System.out.println("Exiting Student Controller - Delete");
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            System.out.println("Exiting Student Controller - Delete (Not Found)");
            return ResponseEntity.notFound().build();
        }
    }
}