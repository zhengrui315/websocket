package com.ruizheng.persistence;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String user1;

    private String user2;

    public Friend(String user1, String user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
}