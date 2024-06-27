package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.converter.UMConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.MissionService.MissionService;
import umc.spring.service.MissionService.MissionServiceImpl;
import umc.spring.service.StoreService.StoreQueryServiceImpl;
import umc.spring.service.UserMissionService.UMService;
import umc.spring.service.UserMissionService.UMServiceImpl;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.UMRequestDTO;
import umc.spring.web.dto.UMResponseDTO;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UMController {

    private final UMService umService;
    private final MissionServiceImpl missionServiceImpl;
    private final MissionConverter missionConverter;

    @PostMapping("/user-id/missions")
    public ApiResponse<UMResponseDTO.umresultDTO> um (@RequestBody @Valid UMRequestDTO.UMDTO request){
        UserMission userMission = umService.makeUM(request);
        return ApiResponse.onSuccess(UMConverter.toUMDTO(userMission));

    }

    @Operation(summary = "특정 유저의 미션 목록 조회 API", description = "특정 유저의 미션들의 목록을 조회하는 API입니다.")
    @GetMapping("/{userId}/missions")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getUserMissionList(@ExistUsers @PathVariable(name = "userId") Long userId,
                                                                                    @CheckPage @RequestParam(name = "page") Integer page) {
        if (page == 1) {
            page = 0;
        }
        Page<Mission> missionList = missionServiceImpl.getUserMissionList(userId, page);
        MissionResponseDTO.MissionPreViewListDTO missionPreviewListDTO = missionConverter.tomissionPreViewList(missionList);
        return ApiResponse.onSuccess(missionPreviewListDTO);
    }

}
