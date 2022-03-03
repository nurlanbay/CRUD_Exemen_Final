package peaksoft.sarvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.entity.Group;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    // Dependency
    private final GroupDao groupDao;

    // Injection
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void saveGroup(Group group) {
        groupDao.saveGroup(group);
    }

    @Override
    public Group getByIdGroup(Long id) {
        return groupDao.getByIdGroup(id);
    }

    @Override
    public void deleteByIdGroup(Long id) {
        groupDao.deleteByIdGroup(id);
    }

    @Override
    public void updateById(Long id) {
        groupDao.updateById(id);
    }

    @Override
    public List<Group> getAllCompany() {
        return groupDao.getAllCompany();
    }
}
