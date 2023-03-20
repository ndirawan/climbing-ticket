package com.enigma.mountains.service;

import com.enigma.mountains.entity.Mountain;

import java.util.List;

public interface MountainService {
    Mountain addMountain(Mountain mountain);
    List<Mountain> getAllMountain();
    Mountain getMountainById(String id);
    Mountain updateMountain(Mountain mountain);
    void deleteMountain(String id);
}
