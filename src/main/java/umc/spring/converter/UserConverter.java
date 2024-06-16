package umc.spring.converter;

import umc.spring.domain.User;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDTO request){
        Gender gender = switch (request.getGender()) {
            case MALE -> Gender.MALE;
            case FEMALE -> Gender.FEMALE;
        };

        return User.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .birthday(request.getBirthday())
                .userPreferenceList(new ArrayList<>())
                .build();
    }
}
