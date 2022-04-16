import "../AdminPages/EditAcademy.css"
import Header from'../Components/Header';
import Footer from'../Components/Footer';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import { padding } from '@mui/system';
import Add from '@mui/icons-material/Add';
import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";

import React, { useState } from 'react';
import { getListSubheaderUtilityClass } from "@mui/material";
import HeaderStudent from "../Components/HeaderStudent";

function ReviewForm(value1) {
  const[userId,setuserid]=useState('')
  const[courseId,setcourseid]=useState('')
  const[starRating,setrating]=useState('')
  const[message,setmessage]=useState('')
  

  
  const handleOnSubmit=(e)=>{
    e.preventDefault()
    const user={courseId,userId,message,starRating}
    console.log(user)
    fetch(value1.value1+"user/addReview",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(user)

  }).then(()=>{
    window.location.href="/user/ViewCourse"

  })
}







   return (
    

      <div>
         <HeaderStudent/>
      <Grid container className="row" columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <input type="text" className="row1"
       
        autoFocus
        value={userId}
        onChange={(e)=>setuserid(e.target.value)}
         placeholder="Enter userId" id="userId"></input>
         </Grid>
         <Grid className='row1'>
         <input type="text" 
        
        autoFocus
        value={courseId}
        onChange={(e)=>setcourseid(e.target.value)}
         className='row1' placeholder="Enter courseId" id="courseId"></input>
         </Grid>
         
      </Grid> 


      <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <textarea type="text" className='row1'
        //   value={mobileNumber}
        autoFocus
        value={message}
        onChange={(e)=>setmessage(e.target.value)}
         placeholder="Enter the message" id="message"></textarea>
         </Grid>
         <Grid className='row1'>
         <input type="text" 
        //   value={password}
        autoFocus
        value={starRating}
        onChange={(e)=>setrating(e.target.value)}
         className='row1' placeholder="Enter the star rating" id="starRating"></input>
         </Grid>
         
      </Grid> 



     

      <div className='btnadd'>

<Button onClick={handleOnSubmit} variant="contained" style={{margin:"5px"}} startIcon={<Add />} color="primary">Add review </Button> 

</div>

</div>
   );
}

export default ReviewForm;



