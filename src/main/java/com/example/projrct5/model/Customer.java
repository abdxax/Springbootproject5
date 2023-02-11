package com.example.projrct5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The name can not be null")
    @Column(columnDefinition = "varchar(70) not null")
    private String name;
    @NotEmpty(message = "The phoneNumber can not be null")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(max = 10)
    private String phoneNumber;
    @NotEmpty(message = "The email can not be null")
    @Column(columnDefinition = "varchar(70) not null")
    @Email
    private String email;
    @ManyToMany
    @JsonIgnore
  //  private Set<Store> storeSet;
    private List<Store> storeSet;

}
