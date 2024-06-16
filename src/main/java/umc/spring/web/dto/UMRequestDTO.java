package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ChallengingMission;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistUsers;


public class UMRequestDTO {

    @Getter
    public static class UMDTO {


        @ExistUsers
        @NotNull(message = "유저 ID는 필수입니다.")
        private Long user;

        @ExistMissions
        @ChallengingMission
        @NotNull(message = "미션 ID는 필수입니다.")
        private Long mission;

    }
}