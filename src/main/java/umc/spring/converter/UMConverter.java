package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.UMRequestDTO;
import umc.spring.web.dto.UMResponseDTO;

import java.time.LocalDateTime;

public class UMConverter {
    public static UMResponseDTO.umresultDTO toUMDTO  (UserMission userMission) {
        return UMResponseDTO.umresultDTO.builder()
                .umID(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserMission toUM(UMRequestDTO.UMDTO request) {
        return UserMission.builder()
                .user(User.builder().id(request.getUser()).build())
                .mission(Mission.builder().id(request.getMission()).build())
                .build();
    }
}