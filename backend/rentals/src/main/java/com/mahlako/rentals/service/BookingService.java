package com.mahlako.rentals.service;

import com.mahlako.rentals.model.Booking;
import com.mahlako.rentals.model.Equipment;
import com.mahlako.rentals.repository.BookingRepository;
import com.mahlako.rentals.repository.EquipmentRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private EquipmentRepository equipmentRepository;
    
    public Booking createBooking(Booking booking){
        
        booking.setStatus("PENDING");
        if(booking.getEquipmentList() != null && !booking.getEquipmentList().isEmpty()){
            
            List<Long> equipmentIds = booking.getEquipmentList().stream().map(Equipment::getId).collect(Collectors.toList());
            
            List<Equipment> managedEquipment = equipmentRepository.findAllById(equipmentIds);
            booking.setEquipmentList(managedEquipment);
        }
        
        return bookingRepository.save(booking);
    }
    
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    
    public Booking updateBookingStatus(Long id, String status){
        
        status = "APPROVED";
        
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if(optionalBooking.isPresent()){
            Booking booking = optionalBooking.get();
            booking.setStatus(status);
            return bookingRepository.save(booking);
        }
        throw new RuntimeException("Booking not found with id: " + id);
    }
}
