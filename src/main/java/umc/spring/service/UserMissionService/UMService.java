package umc.spring.service.UserMissionService;

import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UMRequestDTO;

public interface UMService {
    UserMission makeUM(UMRequestDTO.UMDTO um);
}
