package com.enigma.mountains.service;

import com.enigma.mountains.entity.Climber;

import java.util.List;

public interface ClimberService {
    Climber addClimber(Climber climber);
    Climber getClimberById(String id);
    List<Climber> getAllClimber();
    Climber updateClimber(Climber climber);
    void deleteClimber(String id);
}
