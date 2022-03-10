import React, { Component } from 'react';

import InstitutecardStudent from '../Components/InstituteCard';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import "../Components/HomePage.css";
import {Link,Outlet,} from  "react-router-dom";
import Add from '@mui/icons-material/Add';
import HeaderStudent from '../Components/HeaderStudent';


function StudentInstitute(props) {
    return (
        <div>
                <HeaderStudent/>

<div className="course-search-and-filter">
      <div className="course-search">
        <input
          className="course-search-input"
          type="text"
          name="course"
          placeholder="Search Course"
        ></input>
        <Button variant='outlined' id="searchCourse" className="btn">
          Search
        </Button>
      </div>
      <div className="course-filter">
      <div className='filter1'>Filter By</div>
        
        <Button variant="outlined" > Location</Button>
        <Button variant="outlined" > Institute</Button>
        <Button variant="outlined" > Course</Button>
      </div>
    </div>



                 <Grid  container className="containercard" rowSpacing={1} columnSpacing={{xs:1,sm:2,md:3}}>
            <Grid className="containercard" id="userInstituteGrid1" item xs={12} md={4}>
                <InstitutecardStudent />
                </Grid>
                <Grid className='containercard' id="userInstituteGrid2" item xs={12} md={4}>
                <InstitutecardStudent />
                </Grid>
                <Grid className='containercard' id="userInstituteGrid3" item xs={12} md={4}>
                <InstitutecardStudent />
                </Grid>
                </Grid>
            
               
            

           <Outlet />
            </div>
    );
}

export default StudentInstitute;