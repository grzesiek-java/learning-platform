package pl.coderslab.model.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class LessonDto {

    private Long id;

    @NotEmpty(message = "podaj temat lekcji")
    @Column(unique = true, columnDefinition = "varchar(100)")
    private String title;

    @NotEmpty(message = "dodaj treść lekcji")
    @Column(columnDefinition = "varchar(6000)") // max 65k
    private String content;


    private Long section;


}
