package com.example.projrct5.controller;

import com.example.projrct5.model.Store;
import com.example.projrct5.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    @GetMapping("/getAll")
    public List<Store> getAll(){
        return storeService.storeList();
    }
    @PostMapping("/add")
    public ResponseEntity addStore(@RequestBody @Valid Store store){
        storeService.addStore(store);
       return ResponseEntity.status(200).body("Added Done");

    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Store store){
        if(store==null){
            return ResponseEntity.status(400).body("The store update is empty");
        }
        Boolean res=storeService.update(id,store);
        if(!res||res==null){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
       return ResponseEntity.status(200).body("the Update Is Done ");
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Boolean res=storeService.delete(id);
        if(!res){
            return ResponseEntity.status(400).body("The Id is crrect");
        }
        return ResponseEntity.status(200).body("the Delete Is Done ");
    }


}
