package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.PreferenceHandler;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.Preference;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserPreference;
import umc.spring.repository.PreferenceRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final PreferenceRepository preferenceRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDTO request){
        User newUser = UserConverter.toUser(request);
        List<Preference> preferencesList = request.getUserPreference().stream()
                .map(category -> preferenceRepository.findById(category).orElseThrow(() -> new PreferenceHandler(ErrorStatus.PREFERENCE_NOT_FOUND))).collect(Collectors.toList());
        List<UserPreference> userPreferenceList = UserPreferConverter.toUserPreferList(preferencesList);
        userPreferenceList.forEach(userPreference -> userPreference.setUser(newUser));


        return userRepository.save(newUser);
    }
}
