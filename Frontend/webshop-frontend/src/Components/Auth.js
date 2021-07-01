import React from 'react';
import Login from './Login'
import Register from './Register';

const Auth = () => {
    return(
        <div className="authContainer">
            <Login/>
            <Register/>
        </div>
    );
}

export default Auth;