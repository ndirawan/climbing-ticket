package com.enigma.mountains.service.impl;

import com.enigma.mountains.entity.Climber;
import com.enigma.mountains.repository.ClimberRepository;
import com.enigma.mountains.service.ClimberService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClimberServiceImpl implements ClimberService {
    ClimberRepository climberRepository;

    public ClimberServiceImpl(ClimberRepository climberRepository) {
        this.climberRepository = climberRepository;
    }

    @Override
    public Climber addClimber(Climber climber) {
        return climberRepository.save(climber);
    }

    @Override
    public Climber getClimberById(String id) {
        return climberRepository.findById(id).get();
    }

    @Override
    public List<Climber> getAllClimber() {
        return climberRepository.findAll();
    }

    @Override
    public Climber updateClimber(Climber climber) {
        return climberRepository.save(climber);
    }

    @Override
    public void deleteClimber(String id) {
        climberRepository.delete(getClimberById(id));
    }
}
