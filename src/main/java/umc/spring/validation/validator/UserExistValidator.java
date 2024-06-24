package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.UserRepository;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.validation.annotation.ExistUsers;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUsers, Long> {

    private final UserRepository userRepository;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long userId, ConstraintValidatorContext context) {
        if (userId == null) {
            return false;
        }
        boolean isValid = userRepository.existsById(userId);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 사용자가 존재하지 않습니다.").addConstraintViolation();
        }
        return isValid;

    }
}