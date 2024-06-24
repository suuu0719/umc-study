package umc.spring.service.UserMissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.UMConverter;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.UserMission;
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
