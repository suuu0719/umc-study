package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store-id")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponseDTO.ReviewResultDTO> review(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

}
