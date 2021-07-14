package pl.coderslab.service;

import pl.coderslab.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getLessons();

    void add(Lesson lesson);
}
