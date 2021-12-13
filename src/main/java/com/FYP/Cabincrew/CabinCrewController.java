package com.FYP.Cabincrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cabinCrew")
public class CabinCrewController {
    @Autowired
    private CabinCrewService service;
    @PostMapping
    private CabinCrewDTO save(@RequestBody CabinCrewRequest request){
        return service.save(request);
    }
    @GetMapping
    private Iterable<CabinCrew> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    private CabinCrewDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    private CabinCrewDTO update(@PathVariable String id,@RequestBody CabinCrewRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    private CabinCrewDTO update(@PathVariable String id){
        return service.delete(id);
    }
}
