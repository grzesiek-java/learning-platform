package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "podaj nazwę rozdziału")
    @Size(min = 5,message = "min.5 znaków")
    @Column(columnDefinition = "varchar(50)")
    private String name;

//    @ManyToMany(mappedBy = "sections",fetch = FetchType.LAZY)
//    private List<User> users = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "section",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Lesson> lessons;

}
