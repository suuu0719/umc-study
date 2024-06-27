package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.StoreResponseDTO;
import umc.spring.web.dto.UMRequestDTO;
import umc.spring.web.dto.UMResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
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