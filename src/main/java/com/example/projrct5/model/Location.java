package com.example.projrct5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private Integer id;
    @NotEmpty(message = "The area can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;
    @NotEmpty(message = "The street can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;
}
