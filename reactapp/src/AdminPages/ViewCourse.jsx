import React, { Component } from 'react';

import Button from '@mui/material/Button';
import "./ViewCourse.css";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Delete from '@mui/icons-material/Delete';
import Edit from '@mui/icons-material/Edit';
import Grid from '@mui/material/Grid';
import Add from '@mui/icons-material/Add';
import Typography from '@mui/material/Typography';
import Header from'../Components/Header';
import {Link,Outlet,} from  "react-router-dom";
import CourseSearchFilter from '../Components/CourseSearchFilter';




function ViewCourse(props) {
  return (
    <div>

<Header/>

    <CourseSearchFilter />

                
                <div  className='card1'>
            <Card  className="cardstyle" 
                  sx={{ height: '15%',width:"40%", display: 'flex', flexDirection: 'column',backgroundColor:'#dbaad5'}}
                >
               
                   
                  <CardContent sx={{ flexGrow: 1 }}>
                    {/* <Typography gutterBottom variant="h5" style={{textAlign:"center"}} component="h2">
                      Heading
                    </Typography> */}
                    
                    <Typography style={{textAlign:"center"}}>
                    <Grid container  className="rowgrid"  item xs={12} sm={4} md={12}>
                  <Grid  className="gridelement" >
                  <p>courseId :</p>
                  </Grid>
                  <Grid  className="gridelement">
                  <p>Course Name :</p>
                  </Grid>
                  <Grid   className="gridelement">
                  <p>Duration :</p>
                  </Grid>
                 
               </Grid>

               <Grid container className="rowgrid"  item xs={12} sm={4} md={12}>
                  <Grid  className="gridelement">
                 <p>Students Enrolled:</p>
                  </Grid>
                  <Grid className="gridelement" >
                  <p  >Course Year:</p>
                  </Grid>
                  <Grid className="gridelement">
                  <p>Type:</p>
                  </Grid>
                 
               </Grid>

               <Grid container className="rowgrid"  item xs={12} sm={4} md={12}>
                  <Grid  className="gridelement" >
                 <p>Institute Name:</p>
                  </Grid>
                  </Grid>
                 
                    </Typography>
                  </CardContent>  
                </Card>
                <div>
                <Grid container className="btngrid zindex"  item xs={12} sm={4} md={12}>
               
                  <Grid className="btngrid">
                  <Link to="/admin/EditCourses" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
                  <Button  variant="outlined" style={{margin:"5px"}} id="addCourse" startIcon={<Edit />} color="primary">Edit </Button> 
                 </Link>

                  
                  </Grid>
                  <Grid className="btngrid">

                  <Link to="/admin/DeleteCourses" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
                  <Button  variant="outlined" style={{margin:"5px"}} id="addCourse" startIcon={<Delete />} color="error">Delete</Button> 
                 </Link>
                  
                  </Grid>  
                  </Grid> 
                </div>
        </div>

        <div className='btnadd'>
        {/* <Link to="/admin/AddCourses" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
        <Button  variant="contained" style={{margin:"5px"}} id="addCourse" startIcon={<Add />} color="primary">Add Course </Button>
                 </Link> */}

                 <Link   to="/admin/AddCourses" style={{color:"white",textDecoration:"none"}} target={"_blank"}>
                <Button  variant="contained" style={{margin:"5px"}} startIcon={<Add />} color="primary">Add Course </Button> 
                </Link>
        
        {/* <Link to="/admin/AddCourses" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
        <Button  variant="contained" style={{margin:"5px"}} id="addCourse" startIcon={<Add />} color="primary">Add Course </Button> 
                 </Link>       */}


 
  </div>
  <Outlet />
            </div>
  );
}

export default ViewCourse;

