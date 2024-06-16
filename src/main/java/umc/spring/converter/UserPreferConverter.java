package umc.spring.converter;

import umc.spring.domain.Preference;
import umc.spring.domain.mapping.UserPreference;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPreference> toUserPreferList(List<Preference> preferenceList){

        return preferenceList.stream()
                .map(preference ->
                        UserPreference.builder()
                                .preference(preference)
                                .build()
                ).collect(Collectors.toList());
    }
}
