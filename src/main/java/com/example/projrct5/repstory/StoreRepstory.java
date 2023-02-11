package com.example.projrct5.repstory;

import com.example.projrct5.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepstory extends JpaRepository<Store,Integer> {
    Store findByIdEquals(Integer id);
}

