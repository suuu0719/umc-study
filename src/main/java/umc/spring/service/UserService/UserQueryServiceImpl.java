package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Review> getUserReviewList(Long UserId, Integer page) {
        User user = userRepository.findById(UserId).get();
        return reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
    }
}
