import React, { Component } from 'react';


import "./AddAcademy.css"
import Header from'../Components/Header';
import Footer from'../Components/Footer';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import { padding } from '@mui/system';
import Add from '@mui/icons-material/Add';
import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";



function AddCourse(props) {
    return (
        <div>
            <Header/>
        <Grid container className="row" columnSpacing="3" item xs={12} sm={4} md={12}>
          <Grid className="row1">
          <input type="text" className="row1" placeholder="Enter the course name" id="courseName"></input>
          </Grid>
          <Grid className='row1'>
          <input type="text"  className='row1' placeholder="Enter no of student enrolled for the ourses" id="courseEnrolled"></input>
          </Grid>
          
       </Grid> 


       <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
          <Grid className="row1">
          <input type="text" className='row1' placeholder="Enter the course duration" id="courseDuration"></input>
          </Grid>

          <Grid className='row1'>
          
          <textarea className='row1' placeholder="Enter the course description" id="courseDescription"></textarea>
          </Grid>
         
          
       </Grid> 



       <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
          <Grid className="row1">
          <input type="text" className='row1' placeholder="Enter the course timing" id="courseTiming"></input>
          </Grid>
          
         
       </Grid> 

       <div className='btnadd'>

<Button  variant="contained" style={{margin:"5px"}} id="addCourse" startIcon={<Add />} color="primary">Add Course </Button> 

</div>
<Outlet />
    </div>
    );
}

export default AddCourse;

