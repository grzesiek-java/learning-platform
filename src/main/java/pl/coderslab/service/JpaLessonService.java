package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Lesson;
import pl.coderslab.repository.LessonRepository;

import java.util.List;

@Service
public class JpaLessonService implements LessonService{

    private final LessonRepository lessonRepository;

    public JpaLessonService(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
    @Override
    public void add(Lesson lesson){
        lessonRepository.save(lesson);
    }

}
