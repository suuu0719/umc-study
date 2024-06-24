package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistStores;

@Component
@RequiredArgsConstructor
public class MissionExistsValidator implements ConstraintValidator<ExistMissions, Long> {

    private final MissionRepository missionRepository;

    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missonId, ConstraintValidatorContext context) {
        if (missonId == null) {
            return false;
        }
        boolean isValid = missionRepository.existsById(missonId);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 미션이 존재하지 않습니다.").addConstraintViolation();
        }
        return isValid; // storeId가 존재하지 않으면 false 반환

    }
}