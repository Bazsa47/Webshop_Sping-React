import React from 'react';
import { Link } from 'react-router-dom';

const Property = ({price}) => {
    return(
        <div className="propertyCard">
            <p>
                {price}
            </p>
        </div>   
    );
}

export default Property;