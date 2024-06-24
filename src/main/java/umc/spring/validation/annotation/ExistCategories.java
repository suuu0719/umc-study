package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.CategoriesExistValidator;

import java.lang.annotation.*;

@Documented // 사용자정의 어노테이션 만들때
@Constraint(validatedBy = {CategoriesExistValidator.class}) // 커스텀어노테이션을 통해 validation 할 수 있도록 제공
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) // 어노테이션의 적용범위 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 생명주기 정함 (Runtime동안 유효)

public @interface ExistCategories {
    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
