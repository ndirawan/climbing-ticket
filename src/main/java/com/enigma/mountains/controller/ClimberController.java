package com.enigma.mountains.controller;

import com.enigma.mountains.entity.Climber;
import com.enigma.mountains.service.ClimberService;
import com.enigma.mountains.utils.constant.ApiUrlConstants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstants.CLIMBER_PATH)
public class ClimberController {
    ClimberService climberService;
    public ClimberController(ClimberService climberService) {
        this.climberService = climberService;
    }
    @PostMapping
    public Climber addClimber(@RequestBody Climber climber){
        return climberService.addClimber(climber);
    }
    @GetMapping("/{id}")
    public Climber getClimberById(@PathVariable String id){
        return climberService.getClimberById(id);
    }
    @GetMapping
    public List<Climber> getAllClimber(){
        return climberService.getAllClimber();
    }
    @PutMapping
    public Climber updateClimber(@RequestBody Climber climber){
        return climberService.updateClimber(climber);
    }
    @DeleteMapping("/{id}")
    void deleteClimberById(@PathVariable String id){
        climberService.deleteClimber(id);
    }
}
