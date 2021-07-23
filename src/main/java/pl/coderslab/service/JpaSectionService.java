package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Lesson;
import pl.coderslab.model.Section;
import pl.coderslab.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaSectionService implements SectionService {

    private final SectionRepository sectionRepository;

    public JpaSectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public List<Section> getSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void add(Section section) {
        sectionRepository.save(section);
    }

    @Override
    public Section get(Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }

    @Override
    public Section update(Section section) {
        return sectionRepository.save(section);
    }
}


