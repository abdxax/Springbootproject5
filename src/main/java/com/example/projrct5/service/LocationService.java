package com.example.projrct5.service;

import com.example.projrct5.DTO.LocationDTO;
import com.example.projrct5.hadking.ApiException;
import com.example.projrct5.model.Location;
import com.example.projrct5.model.Store;
import com.example.projrct5.repstory.LocationRepstory;
import com.example.projrct5.repstory.StoreRepstory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepstory locationRepstory;
    private final StoreRepstory storeRepstory;

    public List<Location> getAll(){
        return locationRepstory.findAll();
    }
    public void addLocation(LocationDTO locationDTO){
        Store store=storeRepstory.findByIdEquals(locationDTO.getId());
        if(store==null){
            throw new ApiException("The id is not correct for store");
        }
        Location location=new Location(null,locationDTO.getArea(),locationDTO.getStreet(),store);
        locationRepstory.save(location);

    }

    public Boolean update(Integer id , LocationDTO locationDTO){
        Location location=locationRepstory.findByIdEquals(id);
        if(location==null){
            return false;
        }
        location.setArea(locationDTO.getArea());
        location.setStreet(locationDTO.getStreet());
        locationRepstory.save(location);
        return true;

    }

    public Boolean delete(Integer id ){
        Location location=locationRepstory.findByIdEquals(id);
        Location l=locationRepstory.findByStore_Id(id);
        if(location==null){
            return false;
        }

        locationRepstory.delete(location);
        return true;

    }


}
