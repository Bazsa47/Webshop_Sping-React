import React from 'react';
import { Link } from 'react-router-dom';
import houseph from '../img/houseph.jpg';

const Property = ({price,city}) => {
    return(
        <Link to={`/property/id`}>
        <div className="propertyCard">
            <img src={houseph} alt="" className="propertyCardImg"/>
            <p>{price} FT</p>
            <p>{city}</p>
                
        </div>   
        </Link>
    );
}

export default Property;