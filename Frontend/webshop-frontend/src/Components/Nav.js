import React from 'react';
import { Link } from 'react-router-dom';

const Nav = () => {
    return(
        <div clasName="nav">
            <ul>
                <Link to="/"><li>Home</li></Link>
                <Link to="/properties"><li>Properties</li></Link>
                <Link to="/favourites"><li>Favourites</li></Link>
                <Link to="/Auth"><li>Log In</li></Link>
            </ul>
        </div>
    );
}

export default Nav;