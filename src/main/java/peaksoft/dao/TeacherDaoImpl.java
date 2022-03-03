package peaksoft.dao;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    @Transactional
    public Teacher getByIdTeacher(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public void deleteByIdTeacher(Long id) {
        entityManager.remove(getByIdTeacher(id));
    }

    @Override
    @Transactional
    public void updateById(Long id) {
        entityManager.merge(id);
    }

    @Override
    @Transactional
    public List<Teacher> getAllCompany() {
        List<Teacher> list = entityManager.createQuery("select t from Teacher t", Teacher.class).getResultList();
        return list;
    }
}
