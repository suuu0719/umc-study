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
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.service.StoreService.StoreQueryServiceImpl;
import umc.spring.service.UserService.UserQueryServiceImpl;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;
    private final StoreQueryServiceImpl storeQueryServiceImpl;
    private final StoreConverter storeConverter;


    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> review(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }



    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API입니다.")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name="storeId", description = "가게의 아이디, path variable입니다."),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")})
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStores @PathVariable(name="storeId") Long storeId,
                                                                           @CheckPage @RequestParam(name="page") Integer page){

        if (page == 1 ) {page = 0 ;}

        Page<Review> ReviewList = storeQueryServiceImpl.getReviewList(storeId, page);

        StoreResponseDTO.ReviewPreViewListDTO reviewPreviewListDto = storeConverter.toreviewPreViewListDTO(ReviewList);

        return ApiResponse.onSuccess(reviewPreviewListDto);
    }


}
