package peaksoft.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "study_format", nullable = false)
    StudyFormat studyFormat;

    @ManyToOne(cascade = {DETACH,REFRESH,PERSIST,MERGE,REMOVE})
    Group group;
}
