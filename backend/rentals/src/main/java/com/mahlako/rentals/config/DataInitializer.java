package com.mahlako.rentals.config;

import com.mahlako.rentals.model.Equipment;
import com.mahlako.rentals.repository.EquipmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    
    @Bean
    public CommandLineRunner loadInitialData(EquipmentRepository equipmentRepository){
            return args ->{
                if (equipmentRepository.count() == 0) {
                equipmentRepository.save(new Equipment("Meat Cutter", "a powered food-processing device that slices, portions, minces, or cuts raw, cooked, or frozen meat and bone faster and more uniformly than hand knives"));
                equipmentRepository.save(new Equipment("Portable toilets", "It provides temporary restroom access on construction sites, outdoor events, campsites, and vehicles where permanent facilities are unavailable"));
                equipmentRepository.save(new Equipment("Mobile Freezer", "a portable, insulated freezing unit designed to transport and store frozen or perishable goods on the move or at temporary locations"));
                equipmentRepository.save(new Equipment("Tent", "a portable, collapsible shelter made of flexible fabric stretched over poles and anchored to the ground with stakes or ropes"));
                equipmentRepository.save(new Equipment("Chairs", "Strong black chairs to sit on."));
                System.out.println(">>> Sample equipment data initialized in database!");
                }
            };
    }
}
