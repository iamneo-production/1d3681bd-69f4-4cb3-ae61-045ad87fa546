import React, { Component } from 'react';

import Button from '@mui/material/Button';
import "./Course.css";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Delete from '@mui/icons-material/Delete';
import AddBox from '@mui/icons-material/AddBox';
import Grid from '@mui/material/Grid';
import Add from '@mui/icons-material/Add';
import Typography from '@mui/material/Typography';
// import  from '../Components/InstituteCard';

import {Link,Outlet,} from  "react-router-dom";
import CourseSearchFilter from '../Components/CourseSearchFilter';
import HeaderStudent from '../Components/HeaderStudent';

function EnrolledCourse(props) {
    return (
        <div>
          <HeaderStudent/>
                 <div>
{/* 
<div className="course-search-and-filter">
      <div className="course-search">
        <input id="searchCourse"
          className="course-search-input"
          type="text"
          name="course"
          placeholder="Search Course"
        ></input>
        <Button  variant="outlined"  id="searchCourse" className="btn"> Search</Button>
      </div>
      <div className="course-filter">
        <div className='filter1 '>Filter By</div>
        <Button  variant="outlined" > Course Name</Button>
        <Button  variant="outlined" > Institute Name</Button>
     
      </div>
    </div> */}

    <CourseSearchFilter />

                
                <div  className='card1'>
            <Card  className="cardstyle" 
                  sx={{ height: '15%',width:"40%", display: 'flex', flexDirection: 'column',backgroundColor:'#dbaad5'}}
                >
               
                   
                  <CardContent sx={{ flexGrow: 1 }}>
                    
                    <Typography style={{textAlign:"center"}}>
                    <Grid container  className="rowgrid"  item xs={12} sm={4} md={12}>
                  <Grid  className="gridelement" >
                  <p>course name :</p>
                  </Grid>
                  <Grid  className="gridelement">
                  <p>Number of student :</p>
                  </Grid>
                  <Grid   className="gridelement">
                  <p> Course Duration :</p>
                  </Grid>
                 
               </Grid>

               <Grid container className="rowgrid"  item xs={12} sm={4} md={12}>
                  <Grid  className="gridelement">
                 <p>Course Description :</p>
                  </Grid>
                  <Grid className="gridelement" >
                  <p  >Course Available timing :</p>
                  </Grid>
                  <Grid  className="gridelement" >
                 <p>Institute Name :</p>
                  </Grid>
                 
                 
               </Grid>

                    </Typography>
                  </CardContent>  
                </Card>
                <div>
                <Grid container className="btngrid zindex"  item xs={12} sm={4} md={12}>
               
                  <Grid className="btngrid">
                  <Link to="/user/EnrollCourse" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
                  <Button  variant="outlined" style={{margin:"5px"}} id="addCourse" startIcon={<AddBox />} color="primary">Enroll course </Button> 
                 </Link>

                  
                  </Grid>
                 
                  </Grid> 
                </div>
        </div>

  <Outlet />
            </div>
            </div>
    );
}

export default EnrolledCourse;