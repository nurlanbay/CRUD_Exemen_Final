package peaksoft.sarvice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import peaksoft.dao.CourseDao;
import peaksoft.entity.Course;
import peaksoft.exception.MyException;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CourseServiceImpl implements CourseDao {

    // Dependency
    private final CourseDao courseDao;

    // Injection
    public CourseServiceImpl(@Qualifier("courseDaoImpl") CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void saveCourse(Course course) throws MyException {
        if (course.getId() == 0) {
            courseDao.saveCourse(course);
        }
        throw new MyException();
    }

    @Override
    public Course getByIdCourse(Long id) throws MyException {
        if (id != null) {
            return courseDao.getByIdCourse(id);

        }
        throw new MyException();
    }

    @Override
    public void deleteByIdCourse(Long id) throws MyException {
        if (id != null) {
            courseDao.deleteByIdCourse(id);
        }
        throw new MyException();
    }

    @Override
    public void updateById(Long id) throws MyException {
        if (id != null) {
            courseDao.updateById(id);
        }
        throw new MyException();
    }

    @Override
    public List<Course> getAllCompany() {
        return courseDao.getAllCompany();
    }
}
