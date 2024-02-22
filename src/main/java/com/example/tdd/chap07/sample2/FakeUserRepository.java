package com.example.tdd.chap07.sample2;

import java.util.HashMap;
import java.util.Map;

public class FakeUserRepository implements UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return userMap.get(id);
    }


}
