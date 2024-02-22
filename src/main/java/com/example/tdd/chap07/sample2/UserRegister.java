package com.example.tdd.chap07.sample2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRegister {

    private final WeakPasswordChecker weakPasswordChecker;
    private final UserRepository userRepository;

    public void register(User user) {
        if (weakPasswordChecker.checkPasswordWeekness(user.getPassword())) {
            throw new WeakPasswordException();
        }

        User existingUser = userRepository.findById(user.getId());
        if (existingUser != null) {
            throw new DuplicationIdException();
        } else {
            userRepository.save(user);
        }

    }
}
