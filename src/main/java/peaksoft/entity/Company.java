package peaksoft.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "company_name", nullable = false)
    String companyName;

    @Column(name = "located_country")
    String locatedCountry;

    @OneToMany(cascade = {PERSIST, REMOVE}, orphanRemoval = true)
    @ToString.Exclude
    Set<Course> course;

}
