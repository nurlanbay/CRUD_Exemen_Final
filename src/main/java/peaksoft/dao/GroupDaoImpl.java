package peaksoft.dao;

import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import peaksoft.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class GroupDaoImpl implements GroupDao{

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    @Transactional
    public void saveGroup(Group group) {
        entityManager.persist(group);
    }

    @Override
    @Transactional
    public Group getByIdGroup(Long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    @Transactional
    public void deleteByIdGroup(Long id) {
      entityManager.remove(getByIdGroup(id));
    }

    @Override
    @Transactional
    public void updateById(Long id) {
     entityManager.merge(id);
    }

    @Override
    @Transactional
    public List<Group> getAllCompany() {
        List<Group> list = entityManager.createQuery("select g from Group g",Group.class).getResultList();
        return list;
    }
}
