package com.FYP.Fleet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    @GetMapping("/all")
    public String findALl() {
        return "allaircrafts";
    }
}
