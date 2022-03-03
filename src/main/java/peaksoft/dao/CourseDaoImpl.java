package peaksoft.dao;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Controller
public class CourseDaoImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public Course getByIdCourse(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteByIdCourse(Long id) {
        entityManager.remove(getByIdCourse(id));
    }

    @Override
    public void updateById(Long id) {
        entityManager.merge(id);
    }

    @Override
    public List<Course> getAllCompany() {
        List<Course> list = entityManager.createQuery("select c from Course c",Course.class).getResultList();
        return list;
    }
}
