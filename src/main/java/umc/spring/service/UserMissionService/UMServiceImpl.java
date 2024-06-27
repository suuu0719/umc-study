package umc.spring.service.UserMissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.UMConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UMRepository;
import umc.spring.web.dto.UMRequestDTO;

@Service
@RequiredArgsConstructor
public class UMServiceImpl implements UMService {

    private final UMRepository umRepository;

    @Override
    @Transactional
    public UserMission makeUM (@Valid UMRequestDTO.UMDTO um){
        UserMission newUM = UMConverter.toUM(um);

        return umRepository.save(newUM);
    }



}
