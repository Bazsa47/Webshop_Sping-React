import React from 'react';
import { Link } from 'react-router-dom';
import placeholder from "../img/sample.jpg"

const Nav = () => {
    return(
        <div className="nav">
            <div className="topRow">
                <div className="nav-img-div">
                    <img src={placeholder} alt="" className ="mainImg"/>
                </div>
                <div className="logo">
                    Logo
                </div>
            </div>
            <div className="nav-bar">
                <div className="navElementContainer">
                    <Link to="/"><div className="navElement">Home</div></Link>
                    <Link to="/properties"><div className="navElement">Properties</div></Link>
                    <Link to="/favourites"><div className="navElement">Favs</div></Link>
                    <Link to="/Auth"><div className="navElement">LogIn</div></Link>
                </div>
            </div>
        </div>
    );
}

export default Nav;