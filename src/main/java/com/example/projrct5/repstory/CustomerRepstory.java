package com.example.projrct5.repstory;

import com.example.projrct5.model.Customer;
import com.example.projrct5.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepstory extends JpaRepository<Customer,Integer> {
    Customer findByIdEquals(Integer id);
    List<Customer> findByStoreSet(Store store);
}
