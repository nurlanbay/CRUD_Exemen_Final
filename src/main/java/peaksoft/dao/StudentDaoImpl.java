package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student getByIdStudent(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public void deleteByIdStudent(Long id) {
      entityManager.remove(getByIdStudent(id));
    }

    @Override
    @Transactional
    public void updateById(Long id) {
      entityManager.merge(id);
    }

    @Override
    @Transactional
    public List<Student> getAllStudent() {
      List<Student> list = entityManager.createQuery("select u from Student u",Student.class).getResultList();
      return list;
    }
}
