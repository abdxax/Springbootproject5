package com.example.projrct5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "The name can not be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String name;
   // @NotNull(message = "The bookCount can not be null")
    //@Column(columnDefinition = "not null")
    private Integer bookCount;
    @NotEmpty(message = "The name can not be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String genre;
    @ManyToOne
    @JoinColumn(name = "store_id",referencedColumnName = "id")
    @JsonIgnore
    private Store store;
}
