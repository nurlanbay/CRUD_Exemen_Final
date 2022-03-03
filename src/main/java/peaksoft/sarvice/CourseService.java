package peaksoft.sarvice;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Course course);

    Course getByIdCourse(Long id);

    void deleteByIdCourse(Long id);

    void updateById(Long id);

    List<Course> getAllCompany();
}
