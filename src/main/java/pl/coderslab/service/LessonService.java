package pl.coderslab.service;

import pl.coderslab.model.Lesson;
import pl.coderslab.model.dto.LessonDto;

import java.util.List;
import java.util.Optional;

public interface LessonService {

    List<Lesson> getLessons();

    void add(Lesson lesson);

    Optional<Lesson> get(Long id);

    void delete(Long id);

    Lesson add(LessonDto lessonDto);

    Lesson updateLesson(LessonDto lessonDto);


}
