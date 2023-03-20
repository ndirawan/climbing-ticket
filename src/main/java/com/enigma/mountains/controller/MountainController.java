package com.enigma.mountains.controller;

import com.enigma.mountains.entity.Mountain;
import com.enigma.mountains.service.MountainService;
import com.enigma.mountains.utils.constant.ApiUrlConstants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstants.MOUNTAIN_PATH)
public class MountainController {
    MountainService mountainService;

    public MountainController(MountainService mountainService) {
        this.mountainService = mountainService;
    }
    @PostMapping
    public Mountain addMountain(@RequestBody Mountain mountain){
        return mountainService.addMountain(mountain);
    }
    @GetMapping
    public List<Mountain> getAllMountain(){
        return mountainService.getAllMountain();
    }
    @PutMapping
    public Mountain updateMountain(@RequestBody Mountain mountain){
        return mountainService.updateMountain(mountain);
    }
    @GetMapping("/{id}")
    public Mountain findById(@PathVariable String id){
        return mountainService.getMountainById(id);
    }
    @DeleteMapping("/{id}")
    void deleteMountain(@PathVariable String id){
        mountainService.deleteMountain(id);
    }
}
