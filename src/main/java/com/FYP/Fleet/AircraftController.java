package com.FYP.Fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    @Autowired
    private AircraftService service;
    @PostMapping
    private AircraftDTO save(@RequestBody AircraftRequest request){
        return service.save(request);
    }
    @GetMapping
    private Iterable<Aircraft> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    private AircraftDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    private AircraftDTO update(@PathVariable String id,@RequestBody AircraftRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    private AircraftDTO update(@PathVariable String id){
        return service.delete(id);
    }
}
