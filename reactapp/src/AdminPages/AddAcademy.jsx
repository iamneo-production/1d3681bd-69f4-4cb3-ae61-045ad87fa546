import React, { Component } from 'react';
import "./AddAcademy.css"
import Header from'../Components/Header';
import Footer from'../Components/Footer';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import { padding } from '@mui/system';
import Add from '@mui/icons-material/Add';
import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";




function AddAcademy(props) {
   return (
      <div>
         <Header/>
      <Grid container className="row" columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <input type="text" className="row1" placeholder="Enter Academy name" id="academyName"></input>
         </Grid>
         <Grid className='row1'>
         <input type="text"  className='row1' placeholder="Enter the contact number" id="contactNumber"></input>
         </Grid>
         
      </Grid> 


      <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
         <Grid className="row1">
         <input type="text" className='row1' placeholder="Enter the academy image url" id="imageUrl"></input>
         </Grid>
         <Grid className='row1'>
         <input type="text"  className='row1' placeholder="Enter the academy email" id="emailId"></input>
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

<Button  variant="contained" style={{margin:"5px"}} startIcon={<Add />} color="primary">Add Academy </Button> 

</div>
<Outlet />

</div>
   );
}

export default AddAcademy;

