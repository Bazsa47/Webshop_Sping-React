import React from 'react';
import houseph from '../img/houseph.jpg';

const Property = ({prop}) => {
    return(

            <div className="propertyCard">
                <img src={houseph} alt="" className="propertyCardImg"/>
                <p>{prop.price} FT</p>
                <p>{prop.city}</p>                   
            </div>   

    );
}

export default Property;