package umc.spring.service.MemberService;

import umc.spring.domain.User;
import umc.spring.web.dto.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDTO request);
}
