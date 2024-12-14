package com.example.model;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class User {
private @Nonnull int id;
private String name;
private String email;
private String address;

}
