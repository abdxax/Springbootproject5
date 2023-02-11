package com.example.projrct5.controller;

import com.example.projrct5.DTO.LocationDTO;
import com.example.projrct5.model.Location;
import com.example.projrct5.model.Store;
import com.example.projrct5.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/location")
public class LocationController {
    private final LocationService locationService;
    @GetMapping("/getAll")
    public List<Location> getAll(){
        return locationService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity addLocation(@RequestBody @Valid LocationDTO location){
        locationService.addLocation(location);
       return ResponseEntity.status(200).body("Added Location");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid LocationDTO locationDTO){
        Boolean res=locationService.update(id,locationDTO);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Update Is Done ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean res=locationService.delete(id);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Delete Is Done ");
    }

}
