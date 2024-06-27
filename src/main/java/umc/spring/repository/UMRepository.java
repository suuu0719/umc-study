package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.UserMission;

import java.util.Optional;

public interface UMRepository extends JpaRepository<UserMission, Long> {
    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);

    @Query("SELECT um.mission FROM UserMission um WHERE um.user.id = :userId")
    Page<Mission> findMissionsByUserId(Long userId, Pageable pageable);
}
