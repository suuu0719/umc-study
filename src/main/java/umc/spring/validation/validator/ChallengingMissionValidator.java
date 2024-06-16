package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.UserMission;
import umc.spring.repository.UMRepository;
import umc.spring.validation.annotation.ChallengingMission;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ChallengingMissionValidator implements ConstraintValidator<ChallengingMission, UserMission> {

    private final UMRepository umRepository;

    @Override
    public void initialize(ChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserMission userMission, ConstraintValidatorContext context) {
        Long userId = userMission.getUser().getId();
        Long missionId = userMission.getMission().getId();

        // UMRepository를 사용하여 userId와 missionId를 기반으로 UserMission 조회
        Optional<UserMission> existingMission = umRepository.findByUserIdAndMissionId(userId, missionId);

        // 조회된 UserMission이 있는 경우
        if (existingMission.isPresent()) {
            // 이미 도전중인 미션인 경우
            if (existingMission.get().getStatus() == Status.IN_PROGRESS) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("이미 도전중인 미션입니다.")
                        .addConstraintViolation();
                return false; // 유효성 검사 실패
            }
        }

        return true; // 유효성 검사 통과
    }
}