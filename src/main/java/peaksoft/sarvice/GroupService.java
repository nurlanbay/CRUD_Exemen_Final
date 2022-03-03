package peaksoft.sarvice;

import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {

    void saveGroup(Group group);

    Group getByIdGroup(Long id);

    void deleteByIdGroup(Long id);

    void updateById(Long id);

    List<Group> getAllCompany();
}
