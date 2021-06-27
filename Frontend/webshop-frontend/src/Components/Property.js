import React from 'react';
import { Link } from 'react-router-dom';
import houseph from '../img/houseph.jpg';

const Property = ({price}) => {
    return(
        <div className="propertyCard">
            <img src={houseph} alt="" className="propertyCardImg"/>
            <p>{price} FT</p>
            <p>City</p>
                
        </div>   
    );
}

export default Property;