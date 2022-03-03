package peaksoft.sarvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.TeacherDao;
import peaksoft.entity.Teacher;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    // Dependency
    private final TeacherDao teacherDao;

    // Injection
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDao.saveTeacher(teacher);
    }

    @Override
    public Teacher getByIdTeacher(Long id) {
        return teacherDao.getByIdTeacher(id);
    }

    @Override
    public void deleteByIdTeacher(Long id) {
        teacherDao.deleteByIdTeacher(id);
    }

    @Override
    public void updateById(Long id) {
        teacherDao.updateById(id);
    }

    @Override
    public List<Teacher> getAllCompany() {
        return teacherDao.getAllCompany();
    }
}
