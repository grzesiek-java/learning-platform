package pl.coderslab.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "podaj temat lekcji")
    @Column(unique = true, columnDefinition = "varchar(100)")
    private String title;

    @NotEmpty(message = "dodaj treść lekcji")
    @Column(columnDefinition = "varchar(6000)") // max 65k
    private String content;

    @ManyToOne
    private Section section;

    //@OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "lesson")
//    private Test test;
}
