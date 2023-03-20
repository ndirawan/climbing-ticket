package com.enigma.mountains.service.impl;

import com.enigma.mountains.entity.Mountain;
import com.enigma.mountains.repository.MountainRepository;
import com.enigma.mountains.service.MountainService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MountainServiceImpl implements MountainService {
    MountainRepository mountainRepository;

    public MountainServiceImpl(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    @Override
    public Mountain addMountain(Mountain mountain) {
        return mountainRepository.save(mountain);
    }

    @Override
    public List<Mountain> getAllMountain() {
        return mountainRepository.findAll();
    }

    @Override
    public Mountain getMountainById(String id) {
        return mountainRepository.findById(id).get();
    }

    @Override
    public Mountain updateMountain(Mountain mountain) {
        return mountainRepository.save(mountain);
    }

    @Override
    public void deleteMountain(String id) {
        mountainRepository.delete(getMountainById(id));
    }
}
