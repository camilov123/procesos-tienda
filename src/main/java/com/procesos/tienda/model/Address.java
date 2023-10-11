package com.procesos.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Street Address required")
    @Size(max = 255, message = "Street Address can't exceed 255 characters")
    private String streetAddress;
    @NotNull(message = "City required")
    @Size(max = 255, message = "City can't exceed 255 characters")
    private String city;
    @NotNull(message = "State required")
    @Size(max = 255, message = "State can't exceed 255 characters")
    private String state;
    @NotNull(message = "Postal code required")
    @Size(max = 10, message = "Postal code only can have maximum 10 digits")
    private String postalCode;
    private Boolean status = Boolean.TRUE;
    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
}
