package pl.coderslab.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Size(min = 2)
    @Valid
    @Column(columnDefinition = "varchar(20)")
    private String firstName;

    @Size(min = 2)
    @Valid
    @Column(columnDefinition = "varchar(50)")
    private String lastName;


    @NotEmpty(message = "podaj email")
    @Email(message = "podaj właściwy email")
    @Valid
    @Column(unique = true, columnDefinition = "varchar(50)")
    private String email;

    @Size(min = 1,message = "min.8 znaków")
    @Column(columnDefinition = "varchar(255)")
    private String password;

    private int admin = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Section> sections = new ArrayList<>();
}
