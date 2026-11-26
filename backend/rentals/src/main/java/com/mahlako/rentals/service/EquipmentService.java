package com.mahlako.rentals.service;

import com.mahlako.rentals.model.Equipment;
import com.mahlako.rentals.repository.EquipmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    
    @Autowired
    private EquipmentRepository equipmentRepository;
    
    public List<Equipment> getAllEquipment(){
        return equipmentRepository.findAll();
    }
    
    public Equipment addEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }
    
    public void deleteEquipment(Long id){
        equipmentRepository.deleteById(id);
    }
}
