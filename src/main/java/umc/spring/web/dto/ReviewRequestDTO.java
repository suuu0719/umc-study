package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO{
        @NotNull
        Float score;
        @Size(min = 2, max = 255)
        String body;
        @NotNull
        @ExistStores
        Long storeId;
    }

}
