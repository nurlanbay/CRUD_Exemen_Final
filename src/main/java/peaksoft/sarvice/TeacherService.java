package peaksoft.sarvice;

import peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherService {

    void saveTeacher(Teacher teacher);

    Teacher getByIdTeacher(Long id);

    void deleteByIdTeacher(Long id);

    void updateById(Long id);

    List<Teacher> getAllCompany();
}
