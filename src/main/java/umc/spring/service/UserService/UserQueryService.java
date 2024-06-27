package umc.spring.service.UserService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;

import java.util.Optional;

public interface UserQueryService {
    Page<Review> getUserReviewList(Long UserId, Integer Page);

}
