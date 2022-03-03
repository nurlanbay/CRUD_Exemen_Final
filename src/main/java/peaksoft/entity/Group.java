package peaksoft.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JoinColumn(name = "group_name",nullable = false)
    String groupName;

    @JoinColumn(name = "date_of_start",nullable = false)
    LocalDate dateOfStart;

    @JoinColumn(name = "date_of_finish",nullable = false)
    LocalDate dateOfFinish;

    @OneToMany(mappedBy = "group",cascade = {DETACH,MERGE,PERSIST,REFRESH})
    @ToString.Exclude
    Set<Student> students;

    @ManyToMany(cascade = {DETACH,MERGE,PERSIST,REFRESH})
    @ToString.Exclude
    Set<Course> course;

}