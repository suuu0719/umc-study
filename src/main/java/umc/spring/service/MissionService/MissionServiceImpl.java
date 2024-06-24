package umc.spring.service.MissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission addMission(@Valid MissionRequestDTO.MissionDTO mission) {
        Mission newMission = MissionConverter.toMission(mission);
        return missionRepository.save(newMission);
    }
}
