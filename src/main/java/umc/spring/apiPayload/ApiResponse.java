package umc.spring.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import umc.spring.apiPayload.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {
    @JsonProperty("isSuccess")
    private final boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result; // 어떤 형태의 값이 올지 모르기 때문에 Generic으로 생성

    // 성공한 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }


    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(true, code, message, data);
    }
}
