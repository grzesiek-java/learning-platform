package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;
import pl.coderslab.model.dto.LessonDto;
import pl.coderslab.repository.LessonRepository;
import pl.coderslab.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaLessonService implements LessonService{

    private final LessonRepository lessonRepository;
    private final SectionRepository sectionRepository;


    public JpaLessonService(LessonRepository lessonRepository,SectionRepository sectionRepository){
        this.lessonRepository = lessonRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public List<Lesson> getLessons(){
        return lessonRepository.findAll();
    }
    @Override
    public void add(Lesson lesson){
        lessonRepository.save(lesson);
    }

    @Override
    public Optional<Lesson> get(Long id) {
        return lessonRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Lesson add(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        if(lessonDto.getTitle()!=null && lessonDto.getContent()!=null && lessonDto.getSection()!=null){

            lesson.setTitle(lessonDto.getTitle());
            lesson.setContent(lessonDto.getContent());
            Optional<Section> section = sectionRepository.findById(lessonDto.getSection());

            if(section.isPresent()){
                lesson.setSection(section.get());
            }
            lessonRepository.save(lesson);
        }
        return lesson;
    }

    @Override
    @Transactional
    public Lesson updateLesson(LessonDto lessonDto) {
        Lesson lesson = lessonRepository.getOne(lessonDto.getId());
        if(lessonDto.getTitle()!=null && lessonDto.getContent()!=null && lessonDto.getSection()!=null){

            lesson.setTitle(lessonDto.getTitle());
            lesson.setContent(lessonDto.getContent());
            Optional<Section> section = sectionRepository.findById(lessonDto.getSection());

            if(section.isPresent()){
                lesson.setSection(section.get());
            }
            lessonRepository.save(lesson);
        }
        return lesson;
    }
}
