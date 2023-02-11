package com.example.projrct5.service;

import com.example.projrct5.model.Store;
import com.example.projrct5.repstory.StoreRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepstory storeRepstory;

    public List<Store> storeList(){
        return storeRepstory.findAll();
    }

    public void addStore(Store store){
        storeRepstory.save(store);
    }
    public Boolean update(Integer id,Store store){
      Store s=storeRepstory.findByIdEquals(id);
      if(s==null){
          return  null;
      }
      store.setId(s.getId());
      storeRepstory.save(store);
      return true;
    }

    public Boolean delete(Integer id){
        Store s=storeRepstory.findByIdEquals(id);
        if(s==null){
            return  null;
        }
        storeRepstory.delete(s);
        return true;
    }
}
