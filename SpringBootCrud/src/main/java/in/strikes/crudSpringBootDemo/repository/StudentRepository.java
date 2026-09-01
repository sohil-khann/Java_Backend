package in.strikes.crudSpringBootDemo.repository;

import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {

    private final Map<Long, Student> studentStore = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Student saveStudent(Student studentReq) {
        System.out.println("Inside Student Repository - Save");
        studentReq.setId(idGenerator.getAndIncrement());
        studentStore.put(studentReq.getId(), studentReq);
        System.out.println("Exiting Student Repository - Save");
        return studentReq;
    }

    public List<Student> findAll() {
        System.out.println("Inside Student Repository - Find All");
        return new ArrayList<>(studentStore.values());
    }

    public Student findById(Long id) {
        System.out.println("Inside Student Repository - Find By Id");
        return studentStore.get(id);
    }

    public Student updateStudent(Long id, Student studentReq) {
        System.out.println("Inside Student Repository - Update");
        studentReq.setId(id);
        studentStore.put(id, studentReq);
        System.out.println("Exiting Student Repository - Update");
        return studentReq;
    }

    public void deleteStudent(Long id) {
        System.out.println("Inside Student Repository - Delete");
        studentStore.remove(id);
        System.out.println("Exiting Student Repository - Delete");
    }

    public boolean existsById(Long id) {
        return studentStore.containsKey(id);
    }
}