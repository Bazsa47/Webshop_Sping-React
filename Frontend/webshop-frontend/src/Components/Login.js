import React from 'react';

const Login = () => {
    return (
        <div className="logIn">
            <form>
                <label htmlFor="userNamel">Username</label><br/>
                <input id="userNamel" type="text"/> <br/>
                <label htmlFor="pwl">Password</label><br/>
                <input id="pwl" type="password"/> <br/>
                <button type="submit">Log In</button>
            </form>
        </div>
    );
}

export default Login;