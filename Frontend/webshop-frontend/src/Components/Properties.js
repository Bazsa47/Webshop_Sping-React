import React,{useEffect,useState} from 'react';
import { Link } from 'react-router-dom';
import * as Constants from '../Functions/Constants.js';
import Property from './Property';
import Filter from './Filter';

const Properties = () => {

    const [properties,setProperties] = useState([]);

    useEffect(() => {

        const getProperties = async () =>{
            try {
                const response = await fetch(Constants.BASE_URL+"property")
                const data = await response.json();
               
                for (const property of data) {
                    const response = await fetch(Constants.BASE_URL+"/address/"+property.addressId)
                    const data = await response.json();
                    property["country"] = data.country;
                    property["city"] = data.city;
                    property["street"] = data.street;
                    property["houseNumber"] = data.houseNumber;
                } 
                setProperties(data);

            } catch (error) {
                console.error(error.message)
            }         
        } 

        getProperties();
    },[])

    return(
        <div className="propertiesPage">
            <Filter/>
            <div className="propertiesContainer">
            {properties.map(property => (  
                <Link to={`/property/${property.propertyId}`}>
                    <Property key={property.propertyId} prop={property}/>    
                </Link>  
            ))}
            </div>
        </div>
    );
}

export default Properties;