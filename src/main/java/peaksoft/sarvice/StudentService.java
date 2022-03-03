package peaksoft.sarvice;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student);

    Student getByIdStudent(Long id);

    void deleteByIdStudent(Long id);

    void updateById(Long id);

    List<Student> getAllStudent();
}
