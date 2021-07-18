package pl.coderslab.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String question;

    @NotNull
    private String answer1;

    @NotNull
    private String answer2;

    @NotNull
    private String answer3;

    @NotNull
    private int correct;

//    @OneToOne
//    @JoinColumn(name = "lesson_id")
//    private Lesson lesson;
}
