import React,{useEffect,useState,useCallback} from "react";
import dropzone, { useDropzone } from "react-dropzone";
import axios from "axios"

const EditProfile = () =>{

    function Dropzone(){
        const onDrop =useCallback(acceptedFiles => {
            const file = acceptedFiles[0];
            console.log(file)   
            const formData = new FormData();
            formData.append("file",file);

            axios.post(`http://localhost:8080/user/19/img/upload`,formData,{
                headers:{
                    "Content-type":"multipart/form-data"
                }
            }).then(() => {
                console.log("file uploaded" );
            });
        },[])
        const {getRootProps, getInputProps,isDragActive} = useDropzone({onDrop})

        return(
            <div {...getRootProps()}>
                <input {...getInputProps()}/>
                {
                    isDragActive ? <p>drop files here</p> : <p>drag n drop </p>
                }

            </div>
        );
    }

    return(
        
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
            <Dropzone/>
        </form>
    );
}

export default EditProfile;