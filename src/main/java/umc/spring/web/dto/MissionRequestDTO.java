package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

public class MissionRequestDTO {

    @Getter
    public static class MissionDTO{

        @Size(max=50)
        @NotNull
        String name;
        @NotNull
        Integer point;
        @ExistStores
        @NotNull
        Long storeId;
    }
}
