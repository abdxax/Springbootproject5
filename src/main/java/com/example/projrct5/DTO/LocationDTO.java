package com.example.projrct5.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDTO {
    private Integer id;
    @NotEmpty(message = "The area can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;
    @NotEmpty(message = "The street can not be null")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;
}
