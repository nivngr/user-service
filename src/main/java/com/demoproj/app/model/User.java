package com.demoproj.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @NotNull(message = "Invalid user name")
    @Pattern(regexp = "^[A-Z].*", message = "Name must start with capital letter")
    private String name;
    @Min(12)
    private int age;
    @Email(message = "Invalid email address")
    private String email;
    private Address address;
}
