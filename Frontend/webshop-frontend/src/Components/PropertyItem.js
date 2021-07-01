import React,{useEffect,useState} from 'react';
import {BASE_URL} from '../Functions/Constants';
import Property from './Property';

const PropertyItem = ({match}) =>{

    const [property, setProperty] = useState([]);

    useEffect(() => {
        const getProperty = async () => {
            const data = await fetch(BASE_URL+"/property/"+match.params.id);
            const property = await data.json();

            const response = await fetch(BASE_URL+"/address/"+property.addressId)
            const address = await response.json();
            property["country"] = address.country;
            property["city"] = address.city;
            property["street"] = address.street;
            property["houseNumber"] = address.houseNumber;

            setProperty(property);
        }

        getProperty();
    },[])

    return(
        <div className="propertyItem">
            {console.log(property)}
           <Property prop = {property}/>
        </div>
    );

}

export default PropertyItem;