package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionService {
    Mission addMission(MissionRequestDTO.MissionDTO mission);

}
