package peaksoft.dao;

import peaksoft.entity.Course;
import peaksoft.exception.MyException;

import java.util.List;

public interface CourseDao {

    void saveCourse(Course course) throws MyException;

    Course getByIdCourse(Long id) throws MyException;

    void deleteByIdCourse(Long id) throws MyException;

    void updateById(Long id) throws MyException;

    List<Course> getAllCompany();
}
