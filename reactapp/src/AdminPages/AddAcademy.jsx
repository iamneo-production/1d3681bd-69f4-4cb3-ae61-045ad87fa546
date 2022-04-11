import React, { Component ,useState} from 'react';
import "./AddAcademy.css"
import Header from'../Components/Header';
import Footer from'../Components/Footer';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import { padding } from '@mui/system';
import Add from '@mui/icons-material/Add';
import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";
import { BackspaceOutlined } from '@mui/icons-material';




function AddAcademy(props) {
   const[name,setname]=useState('')
   const[email,setdescription]=useState('')
  //  const[mobileNumber,setstate]=useState('')
   
   const[password,setcity]=useState('')
   const[instituteEmail,setemail]=useState('')
   const[mobileNumber,setmobile]=useState('')
  //  const[nirfRank,setrank]=useState('')

  const handleOnSubmit=(e)=>{
     e.preventDefault()
     // const user={instituteName,instituteDescription,instituteState,instituteCity,instituteEmail,instituteMobile,nirfRank}
     const user={name,email,password,mobileNumber}
     console.log(user)
     fetch("http://localhost:8080/UserModel",{
        

        // mode:'cors',
        // credentials:'include',
       method:"POST",
       headers:{"Content-Type":"application/json"},
       body:JSON.stringify(user)
 
   }).then(()=>{
     window.location.href="/admin/ViewInstitute"

   })
 }



   return (
      <div>
         <Header/>
      <Grid container className="row" columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <input type="text" className="row1"
          autoFocus
          value={name}
          onChange={(e)=>setname(e.target.value)}
         placeholder="Enter Academy name" id="academyName"></input>
         </Grid>
         <Grid className='row1'>
         <input type="text"  className='row1'
          autoFocus
          value={mobileNumber}
          onChange={(e)=>setmobile(e.target.value)}
         placeholder="Enter the contact number" id="contactNumber"></input>
         </Grid>
         
      </Grid> 


      <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <input type="text" className='row1'
          autoFocus
          value={email}
          onChange={(e)=>setdescription(e.target.value)}
         placeholder="Enter the academy image url" id="imageUrl"></input>
         </Grid>
         <Grid className='row1'>
         <input type="text" 
          autoFocus
          value={password}
          onChange={(e)=>setcity(e.target.value)}
         className='row1' placeholder="Enter the academy email" id="emailId"></input>
         </Grid>
         
      </Grid> 



      <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <input type="text" className='row1' placeholder="Enter academy location" id="academyLocation"></input>
         </Grid>
         <Grid className='row1'>
         {/* <input type="text"  className='row1' placeholder="Enter academy description" id="academyDescription"></input> */}
         <textarea className='row1' placeholder="Enter academy description" id="academyDescription"></textarea>
         </Grid>
         
      </Grid> 

      <div className='btnadd'>
      <span>
<Button 
 onClick={handleOnSubmit}
variant="contained" style={{margin:"5px"}} startIcon={<Add />} color="primary">Add Academy </Button> 
 </span>
{/* <span>
<Link   to="/admin/ViewInstitute" style={{color:"white",textDecoration:"none"}}  >

<Button 
 className="btn btn-submit"
//  onClick={getemail}
  type="submit"
variant="contained" style={{margin:"5px"}} startIcon={<BackspaceOutlined/>} color="primary">Back</Button> 
  </Link> 
  </span> */}
</div>
<Outlet />

</div>
   );
}

export default AddAcademy;

