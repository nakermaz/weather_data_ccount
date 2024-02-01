package com.example.beta.web.controllers;

import com.example.beta.web.models.Sensor;
import com.example.beta.web.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/measurements")
public class SensorController {

    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/sensor")
    public ResponseEntity<HttpStatus> create(@RequestBody Sensor sensor){
        sensorService.save(sensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
