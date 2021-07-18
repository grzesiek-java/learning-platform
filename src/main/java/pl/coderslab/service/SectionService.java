package pl.coderslab.service;

import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {

    List<Section> getSections();

    void add(Section section);

    Optional<Section> get(Long id);

    void delete(Long id);
}
