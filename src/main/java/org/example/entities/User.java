package org.example.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Random;

// Data -> from lombok
// instead of getters / setters
@Data
@Accessors(chain = true)
// DTO - data transfer object
public class User {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}
