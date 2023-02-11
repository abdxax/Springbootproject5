package com.example.projrct5.service;

import com.example.projrct5.hadking.ApiException;
import com.example.projrct5.model.Book;
import com.example.projrct5.model.Customer;
import com.example.projrct5.model.Store;
import com.example.projrct5.repstory.BookRepstory;
import com.example.projrct5.repstory.CustomerRepstory;
import com.example.projrct5.repstory.StoreRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepstory customerRepstory;
    private final StoreRepstory storeRepstory;
    public List<Customer> customerList(){
        return customerRepstory.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepstory.save(customer);
    }


    public Boolean update(Integer id,Customer customer ){
        Customer c=customerRepstory.findByIdEquals(id);
        if(c==null){
            return  null;
        }
        customer.setId(c.getId());
        customerRepstory.save(customer);
        return true;
    }

    public Boolean delete(Integer id){
        Customer s=customerRepstory.findByIdEquals(id);
        if(s==null){
            return  null;
        }
        customerRepstory.delete(s);
        return true;
    }

    public Boolean assignToStore(Integer storeId,Integer customerId){
        Store store=storeRepstory.findByIdEquals(storeId);
        Customer customer=customerRepstory.findByIdEquals(customerId);
        if(store==null||customer==null){
            return false;
        }
        store.getCustomers().add(customer);
        customer.getStoreSet().add(store);
        storeRepstory.save(store);
        customerRepstory.save(customer);
        return true;
    }

    public List<Customer> getByStore(Integer storeId){
        Store store=storeRepstory.findByIdEquals(storeId);
        if(store==null){
            throw new ApiException("The Id is not correct");
        }
        return customerRepstory.findByStoreSet(store);
    }
}
