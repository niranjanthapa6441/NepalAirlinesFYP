package com.FYP.Pilot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pilot")
public class PilotController {
    @Autowired
    private PilotService service;
    @PostMapping
    private PilotDTO save(@RequestBody PilotRequest request){
        return service.save(request);
    }
    @GetMapping
    private Iterable<Pilot> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    private PilotDTO findById(@PathVariable String id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    private PilotDTO update(@PathVariable String id,@RequestBody PilotRequest request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    private PilotDTO update(@PathVariable String id){
        return service.delete(id);
    }
}
