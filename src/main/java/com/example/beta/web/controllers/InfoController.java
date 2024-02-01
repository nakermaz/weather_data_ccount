package com.example.beta.web.controllers;

import com.example.beta.web.dto.InfoDTO;
import com.example.beta.web.models.Info;
import com.example.beta.web.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping()
    public List<InfoDTO.Request.Home> getInfos(){
        return infoService.findAll();
    }

    @GetMapping("/rainyDaysCount")
    public List<Info> getRainsDays(){
        return infoService.findAllRainsDays();
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody Info info){
        infoService.save(info);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable int id, @RequestBody Info info){
        infoService.update(id, info);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        infoService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
