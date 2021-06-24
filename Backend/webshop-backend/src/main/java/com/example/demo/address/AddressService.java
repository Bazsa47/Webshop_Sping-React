package com.example.demo.address;

import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToStdout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public void addAddress(Address a) {
        addressRepository.save(a);
    }

    @Transactional
    public void updateAddress(long addressId, String country, String city, String street, String houseNumber) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new IllegalStateException("Address id does not exists!"));
        if (isValid(country) && country != address.getCountry()) address.setCountry(country);
        if (isValid(city) && city != address.getCity()) address.setCity(city);
        if (isValid(street) && street != address.getStreet()) address.setStreet(street);
        if (isValid(houseNumber) && houseNumber != address.getHouseNumber()) address.setHouseNumber(houseNumber);
    }

    public void deleteAddress(long addressId) {
        if (!addressRepository.findById(addressId).isPresent()) throw new IllegalStateException("Address id does not exists!");
        addressRepository.deleteById(addressId);
    }

    public boolean isValid(String value){
        return value != null && value.trim() != "";
    }
}
