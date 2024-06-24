package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Preference;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
