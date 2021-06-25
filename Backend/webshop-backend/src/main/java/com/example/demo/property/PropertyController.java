package com.example.demo.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.functions.Constants;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/property")
@CrossOrigin(origins=Constants.WEB_URL)
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<Property> getProperties(){
        return propertyService.getProperties();
    }

    @GetMapping(path = "{propertyId}")
    public Optional<Property> getPropertyById(@PathVariable("propertyId") long propertyId){
        return propertyService.getPropertyById(propertyId);
    }

    @PostMapping
    public void addProperty(@RequestBody Property p){
        propertyService.saveProperty(p);
    }

    @PutMapping(path = "{propertyId}")
    public void updateProperty(@PathVariable("propertyId") Long propertyId,
                               @RequestParam(required = false) Integer price,
                               @RequestParam(required = false) Integer area,
                               @RequestParam(required = false) boolean garden,
                               @RequestParam(required = false) Byte rooms,
                               @RequestParam(required = false) boolean clime,
                               @RequestParam(required = false) boolean balcony,
                               @RequestParam(required = false) String heating,
                               @RequestParam(required = false) Long advertiserId,
                               @RequestParam(required = false) Long addressId){
        if(area == null) area = -1;
        if(price == null) price = -1;
        if(rooms == null) rooms = -1;
        if (advertiserId == null) advertiserId = 0L;
        if(addressId == null) addressId = 0L;
        propertyService.updateProperty(propertyId ,price,area,garden,rooms,clime,balcony,heating,advertiserId,addressId);

    }

    @DeleteMapping(path = "{propertyId}")
    public void deleteProperty(@PathVariable("propertyId") long propertyId){
        propertyService.deleteProperty(propertyId);
    }


}
