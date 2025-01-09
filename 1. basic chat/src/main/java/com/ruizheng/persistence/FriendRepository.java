package com.ruizheng.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository  extends JpaRepository<Friend, Integer> {
    @Query("SELECT f FROM Friend f WHERE f.user1 = :name")
    List<User> getFriends(String name);
}
