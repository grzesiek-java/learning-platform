package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
