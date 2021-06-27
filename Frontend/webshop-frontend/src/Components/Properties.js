import React,{useEffect,useState} from 'react';
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
                setProperties(data);
                console.log(properties);
                console.log(data); 
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
                
                    <Property  price={property.price}/>
                
            ))}
        </div>
        </div>
    );
}

export default Properties;