import React, { Component } from 'react';
import "./AddAcademy.css"
import Header from'../Components/Header';
import Footer from'../Components/Footer';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import { padding } from '@mui/system';
import Add from '@mui/icons-material/Add';
import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";



function EditCourse(props) {
    return (
        <div>
            <Header/>
                <Grid container className="row" columnSpacing="3" item xs={12} sm={4} md={12}>
                  <Grid className="row1">
                  <input type="text" className="row1" placeholder="Enter the course name" id="editCourseName"></input>
                  </Grid>
                  <Grid className='row1'>
                  <input type="text"  className='row1' placeholder="Enter no of student enrolled for the ourses" id="editCourseEnrolled"></input>
                  </Grid>
                  
               </Grid> 


               <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
                  <Grid className="row1">
                  <input type="text" className='row1' placeholder="Enter the course duration" id="editCourseDuration"></input>
                  </Grid>

                  <Grid className='row1'>
                  
                  <textarea className='row1' placeholder="Enter the course description" id="editCourseDescription"></textarea>
                  </Grid>
                 
                  
               </Grid> 



               <Grid container className='row' columnSpacing="3" item xs={12} sm={4} md={12}>
                  <Grid className="row1">
                  <input type="text" className='row1' placeholder="Enter the course timing" id="editCourseTiming"></input>
                  </Grid>
                  
                 
               </Grid> 

               <div className='btnadd'>

<Button  variant="contained" style={{margin:"5px"}} id="updateCourse" startIcon={<Add />} color="primary">Edit Course </Button> 
 
  </div> 
            </div>
    );
}

export default EditCourse;

