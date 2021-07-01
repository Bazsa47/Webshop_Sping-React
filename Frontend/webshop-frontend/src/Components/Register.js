import React from 'react';

const Register = () => {
    return (
        <div className = "register">
                <form>
                    <label htmlFor="userName">Username</label><br/>
                    <input id="userName" type="text"/> <br/>
                    <label htmlFor="fullname">Full name</label><br/>
                    <input id="fullname" type="text"/> <br/>

                    <label htmlFor="pw">Password</label><br/>
                    <input id="pw" type="password"/> <br/>
                    <label htmlFor="cpw">Confirm password</label><br/>
                    <input id="cpw" type="password"/> <br/>

                    <label htmlFor="email">Email</label><br/>
                    <input id="email" type="password"/> <br/>
                    <label htmlFor="phone">Phone number</label><br/>
                    <input id="phone" type="text"/> <br/>
                    <label htmlFor="intro">Introduction</label><br/>
                    <textarea name="intro" id="intro"></textarea><br/>

                    <button type="submit">Register</button>
                </form>

            </div>
    );
}

export default Register;