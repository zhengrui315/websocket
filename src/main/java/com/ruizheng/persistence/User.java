package com.ruizheng.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class User {
    @Id
    private String name;

    private String address;
}