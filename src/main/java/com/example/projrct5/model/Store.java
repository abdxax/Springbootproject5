package com.example.projrct5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "store")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The Name can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Location location;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
   // private Set<Book> bookSet=new HashSet<>();
    private List<Book> bookSet;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "storeSet")
    //private Set<Customer> customers=new HashSet<>();
    private List<Customer> customers;
}
