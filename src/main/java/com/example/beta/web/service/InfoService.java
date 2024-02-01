package com.example.beta.web.service;

import com.example.beta.web.dto.InfoDTO;
import com.example.beta.web.models.Info;
import com.example.beta.web.repositories.InfoRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@Transactional
public class InfoService {

    private final InfoRepository infoRepository;

    protected static final Logger logger = LogManager.getLogger();

    @Autowired
    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public List<InfoDTO.Request.Home> findAll(){
        logger.info("находит всю информацию из бд");
        List<InfoDTO.Request.Home> homeList = infoRepository.findAll()
                .stream().map(this::convertList).collect(Collectors.toList());

        return homeList;
    }

    public List<Info> findAllRainsDays(){
        logger.info("запуск falcon 9");
        return infoRepository.findRainingDays();
    }

    @Transactional
    public void save(Info info){
        logger.info("идет сохранение в бд");
        infoRepository.save(info);
    }

    public void update(int id, Info info){

        Info updateInfo = infoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Info not exist with id: " + id));

        updateInfo.setValue(info.getValue());
        updateInfo.setRaining(info.isRaining());
        updateInfo.setSensor(info.getSensor());

        logger.info("Обновление данных");
        infoRepository.save(updateInfo);
    }

    public void delete(int id) {
        logger.info("удаление данных");
        infoRepository.deleteById(id);
    }

    public InfoDTO.Request.Home convertList (Info info){

        InfoDTO.Request.Home home = new InfoDTO.Request.Home();
        home.setId(info.getId());
        home.setValue(info.getValue());
        home.setRaining(info.isRaining());

        return home;
    }

}
