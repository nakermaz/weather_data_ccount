package com.example.beta.web.service;

import com.example.beta.web.models.Sensor;
import com.example.beta.web.repositories.SensorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    @Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }
}
