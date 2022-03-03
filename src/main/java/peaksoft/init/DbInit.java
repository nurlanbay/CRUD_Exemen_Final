package peaksoft.init;

import org.springframework.stereotype.Component;
import peaksoft.dao.CompanyDao;
import peaksoft.entity.*;

import javax.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Component
public class DbInit {

    // Dependency
    private final CompanyDao companyDao;

     // Injection
    public DbInit(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @PostConstruct
    public void init() {

        Company company = new Company();
        company.setCompanyName("Peaksoft");
        company.setLocatedCountry("Kyrgyzstan");

        Teacher teacher = new Teacher();
        teacher.setFirstName("Chyngyz");
        teacher.setLastName("Kamarov");
        teacher.setEmail("kamarov@gmail.com");

        Course course = new Course();
        course.setCourseName("Java");
        course.setCompany(company);
        course.setDurationMonth(LocalDate.now().plusMonths(9));
        course.setTeacher(teacher);
        teacher.setCourse(course);
        company.setCourse(Set.of(course));

        Group group = new Group();
        group.setGroupName("Java Batch 5");
        group.setCourse(Set.of(course));
        course.setGroup(List.of(group));
        group.setDateOfStart(LocalDate.now());
        group.setDateOfFinish(LocalDate.now().plusYears(1));

        Student student = new Student();
        student.setFirstName("Nurlan");
        student.setLastName("Atayarov");
        student.setEmail("nurln@gmail.com");
        student.setStudyFormat(StudyFormat.OFFLINE);
        student.setGroup(group);
        group.setStudents(Set.of(student));

        companyDao.saveCompany(company);
    }
}
