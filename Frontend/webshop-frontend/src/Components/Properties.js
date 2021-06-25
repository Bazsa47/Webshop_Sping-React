import React,{useEffect,useState} from 'react';
import * as Constants from '../Functions/Constants.js';
import Property from './Property';

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
            <h1>PROPERTIES</h1>
            {properties.map(property => (
                <div key={property.propertyId}>
                    <Property  price={property.price}/>
                    {console.log(properties)}
                </div>
            ))}
        </div>
    );
}

export default Properties;