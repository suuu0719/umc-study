package umc.spring.service.UserMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UMRequestDTO;

public interface UMService {
    UserMission makeUM(UMRequestDTO.UMDTO um);

}
