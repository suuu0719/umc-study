package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.UMConverter;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.UserMissionService.UMService;
import umc.spring.web.dto.UMRequestDTO;
import umc.spring.web.dto.UMResponseDTO;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UMController {
    private final UMService umService;

    @PostMapping("/user-id/missions")
    public ApiResponse<UMResponseDTO.umresultDTO> um (@RequestBody @Valid UMRequestDTO.UMDTO request){
        UserMission userMission = umService.makeUM(request);
        return ApiResponse.onSuccess(UMConverter.toUMDTO(userMission));

    }

}
