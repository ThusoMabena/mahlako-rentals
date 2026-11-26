package com.mahlako.rentals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mahlako.rentals.model.Equipment;
import com.mahlako.rentals.service.EquipmentService;
import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    
    @Autowired
    private EquipmentService equipmentService;
    
    @GetMapping
    public List<Equipment>getAllEquipment(){
        return equipmentService.getAllEquipment();
    }
    
    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment){
        return equipmentService.addEquipment(equipment);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id){
        equipmentService.deleteEquipment(id);
    }
}
