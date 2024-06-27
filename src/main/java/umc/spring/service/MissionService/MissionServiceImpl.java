package umc.spring.service.MissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.UMRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.MissionRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final UMRepository umRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Mission addMission(@Valid MissionRequestDTO.MissionDTO mission) {
        Mission newMission = MissionConverter.toMission(mission);
        return missionRepository.save(newMission);
    }

    @Override
    public Page<Mission> getUserMissionList(Long userId, Integer page) {
        User user =userRepository.findById(userId).get();
        return umRepository.findMissionsByUserId(userId, PageRequest.of(page, 10));
    }


}
