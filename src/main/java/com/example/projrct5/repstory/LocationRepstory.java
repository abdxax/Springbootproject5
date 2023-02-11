package com.example.projrct5.repstory;

import com.example.projrct5.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepstory extends JpaRepository<Location,Integer> {
    Location findByIdEquals(Integer id);
    Location findByStore_Id(Integer id);
}
