package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.domain.enums.Gender;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistStores;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Gender gender;
        @NotNull
        LocalDate birthday;
        @Size(max=30)
        String email;
        @NotNull
        String phoneNumber;
        @Size(min=1, max=30)
        String address;
        @ExistCategories
        List<Long> userPreference;

    }


}
