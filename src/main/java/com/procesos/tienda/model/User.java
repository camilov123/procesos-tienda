package com.procesos.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "First name is required")
    @Size(max = 255, message = "Name can't exceed 255 characters")
    private String firstName;
    @NotNull(message = "Last name name required")
    @Size(max = 255, message = "Last name can't exceed 255 characters")
    private String lastName;
    @NotNull(message = "Document required")
    @Size(min = 5, max = 15, message = "Document min 5 characters and can't exceed 15 characters")
    private String document;
    private String phone;
    @NotNull(message = "Email required")
    @Email(message = "Email format not valid")
    private String email;
    @JsonIgnore
    @NotNull(message = "Password required")
    @Size(min = 8, max = 15, message = "Password must have min 8 characters and maximum 15 characters")
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Address> addressList;
}
