package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;

public class MissionConverter {
    public static MissionResponseDTO.MissionResultDTO toMissionResultDTO(Mission mission) {
        return MissionResponseDTO.MissionResultDTO.builder()
                .missionID(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionDTO request) {
        return Mission.builder()
                .name(request.getName())
                .point(request.getPoint())
                .store(Store.builder().id(request.getStoreId()).build())
                .build();

    }
}
