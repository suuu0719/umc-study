package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;

import java.util.Optional;

public interface MissionService {
    Mission addMission(MissionRequestDTO.MissionDTO mission);
    Page<Mission> getUserMissionList(Long UserId, Integer page);

}
