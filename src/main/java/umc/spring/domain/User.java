package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.UserAgree;
import umc.spring.domain.mapping.UserMission;
import umc.spring.domain.mapping.UserPreference;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA가 통신을 하는 DBMS의 방식을 따른다
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    private LocalDate birthday;

    @Column(nullable = false, length = 30)
    private String email;

    private String phoneNumber;

    @Column(nullable = false, length = 30)
    private String address;

    private Integer point;

    // Review, User_Preference, User_Agree, User_Mission

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPreference> userPreferenceList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissionList = new ArrayList<>();


}
