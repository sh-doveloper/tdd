package com.example.tdd.chap07.sample2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // InjectMock, Mock 을 사용할때 필요하다.
public class UserRegisterTest {

    //    @InjectMocks
    UserRegister userRegister;
    //    @Mock
    StubWeakPasswordChecker stubWeakPasswordChecker;
    //    @Mock
    FakeUserRepository fakeUserRepository;

    @BeforeEach
    void setUp() {
        stubWeakPasswordChecker = new StubWeakPasswordChecker();
        fakeUserRepository = new FakeUserRepository();
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeUserRepository);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubWeakPasswordChecker.setWeakness(true); // 암호가 약하다고 셋팅

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register(
                User.builder().id("id").password("password").email("email@email.com").build());
        });
    }

    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    @Test
    void duplicateId() {
        fakeUserRepository.save(User.builder()
            .id("id")
            .password("password1")
            .email("email@email.com")
            .build());

        assertThrows(DuplicationIdException.class, () -> {
            userRegister.register(
                User.builder().id("id").password("password1").email("email2@email2.com").build());
        });
    }

    @DisplayName("같은 ID가 없으면 가입 성공")
    @Test
    void noId_ThenRegisterSuccess() {
        userRegister.register(
            User.builder()
                .id("id")
                .password("password1")
                .email("email@email.com")
                .build());

        User savedUser = fakeUserRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email@email.com", savedUser.getEmail());
    }


}
