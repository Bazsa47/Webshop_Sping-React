package com.example.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping(path="{addressId}")
    public Optional<Address> getAddressById(@PathVariable("addressId") long addressId){
        return addressService.getAddressById(addressId);
    }

    @PostMapping
    public void addAddress(@RequestBody Address a){
        addressService.addAddress(a);
    }

    @PutMapping(path ="{addressId}")
    public void updateAddress(@PathVariable("addressId") int addressId,
                              @RequestParam(required = false) String country,
                              @RequestParam(required = false) String city,
                              @RequestParam(required = false) String street,
                              @RequestParam(required = false) String houseNumber){
        addressService.updateAddress(addressId,country,city,street,houseNumber);

    }

    @DeleteMapping(path ="{addressId}")
    public void deleteAddress(@PathVariable("addressId") long addressId){
        addressService.deleteAddress(addressId);
    }
}
