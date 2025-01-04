package com.ruizheng.persistence;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FriendRepository friendRepository;

    public void addUser(String name, String address) {
        User.UserBuilder userBuilder = User.builder().name(name);
        if (Strings.isNotEmpty(address)) {
            userBuilder.address(address);
        }
        userRepository.save(userBuilder.build());
    }

    public void addFriend(String user1, String user2) {
        friendRepository.save(new Friend(user1, user2));
        friendRepository.save(new Friend(user2, user1));
    }

    public List<String> getAllFriends(String name) {
        return friendRepository.getFriends(name).stream().map(User::getName).collect(Collectors.toList());
    }
}
