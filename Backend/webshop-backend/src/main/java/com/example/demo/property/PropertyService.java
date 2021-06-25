package com.example.demo.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    private final PropertyRepository propertyRepository;


    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public void saveProperty(Property p) {
        propertyRepository.save(p);
    }

    @Transactional
    public void updateProperty(Long propertyId, int price, Integer area, boolean garden, byte rooms, boolean clime, boolean balcony, String heating, long advertiserId, long addressId) {
        Property p = propertyRepository.findById(propertyId).orElseThrow(() -> new IllegalStateException("Property ID does not exist!"));
        if (isValid(price) && price != p.getPrice() && price != -1) p.setPrice(price);
        if (area != 0 && area != p.getArea() && area != -1) p.setArea(area);
        if (isValid(garden) && garden != p.getGarden()) p.setGarden(garden);
        if (rooms != p.getRooms() && rooms != -1) p.setRooms(rooms);
        if (isValid(clime) && clime != p.getClime()) p.setClime(clime);
        if (isValid(balcony) && balcony != p.getBalcony()) p.setBalcony(balcony);
        if (isValid(heating) && heating != p.getHeating()) p.setHeating(heating);
        if (advertiserId != 0&& advertiserId != p.getAdvertiserId() && addressId != 0) p.setAdvertiserId(advertiserId);
        if (addressId != 0 && addressId != p.getAddressId() && addressId != 0) p.setAddressId(addressId);
    }


    public void deleteProperty(long propertyId) {
        if(!propertyRepository.findById(propertyId).isPresent()) throw new IllegalStateException("Property ID does not exist!");
        propertyRepository.deleteById(propertyId);
    }

    public boolean isValid(Object value){
        return value.toString() != null && value.toString().trim() != "";
    }

    public Optional<Property> getPropertyById(long propertyId) {
        if (!propertyRepository.findById(propertyId).isPresent()) throw new  IllegalStateException("Property id does not exist!");
        return propertyRepository.findById(propertyId);
    }
}
