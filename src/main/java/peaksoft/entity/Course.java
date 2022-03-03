package peaksoft.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "course_name", nullable = false)
    String courseName;

    @Column(name = "duration_month", nullable = false)
    LocalDate durationMonth;

    @ManyToOne(cascade = ALL)
    Company company;

    @ManyToMany(cascade = {DETACH,REFRESH,PERSIST,MERGE,REMOVE})
    List<Group> group;

    @OneToOne(cascade = {DETACH,REFRESH,PERSIST,MERGE,REMOVE})
    Teacher teacher;
}
