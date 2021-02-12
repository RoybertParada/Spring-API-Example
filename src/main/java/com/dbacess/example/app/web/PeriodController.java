package com.dbacess.example.app.web;

import com.dbacess.example.app.domain.*;
import com.dbacess.example.app.domain.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/period")
public class PeriodController {
    @Autowired
    private PeriodService periodService;

    @GetMapping("/all")
    public ResponseEntity<List<Period>> getAll(){
        return new ResponseEntity<>(periodService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{periodId}")
    public ResponseEntity<?> getCourse(@PathVariable PeriodId periodId){
        return periodService.getPeriod(periodId)
                .map(course -> new ResponseEntity<>(course, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Period period) {
        return new ResponseEntity<>(periodService.save(period), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody PeriodId id){
        if (periodService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
