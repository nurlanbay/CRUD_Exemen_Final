package peaksoft.sarvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    // Dependency
    private final StudentDao studentDao;

    // Injection
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);

    }

    @Override
    public Student getByIdStudent(Long id) {
        return studentDao.getByIdStudent(id);
    }

    @Override
    public void deleteByIdStudent(Long id) {
        studentDao.deleteByIdStudent(id);
    }

    @Override
    public void updateById(Long id) {
        studentDao.updateById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
}
