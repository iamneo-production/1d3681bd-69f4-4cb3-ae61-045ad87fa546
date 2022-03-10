import Header from'../Components/Header';
import RowView from'./RowView';
import Button from '@mui/material/Button';

import Grid from '@mui/material/Grid';

import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import './DisplayUser.css';
// import Link from '@mui/material/Link'
import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";
import IconButton from '@mui/material/IconButton';
import Delete from '@mui/icons-material/Delete';
import Edit from '@mui/icons-material/Edit';
import Add from '@mui/icons-material/Add';
import Search from '@mui/icons-material/Search';
import {Table,TableHead,TableRow,TableBody} from '@mui/material';








function DisplayUser(){
    
    return(


<div>
{/* <form action="" >
<Grid container className='containsrch'>
  <Grid  item xs={12} md={6}>
    <input className='search' type="text" />
  </Grid>
  <Grid item xs={12} md={6}> <Button className='srchbtn' variant="contained"  color="primary" endIcon={<Search />}  >Search</Button></Grid>
</Grid>
</form> */}
<Header/>


<div className="course-search-and-filter">
      <div className="course-search">
        <input
          className="course-search-input"
          type="text"
          name="course"
          placeholder="Search Course"
        ></input>
        <Button  variant="outlined"  id="searchCourse" className="btn"> Search</Button>
      </div>
      <div className="course-filter">
        <div className='filter1'>Filter By</div>
        
        <Button variant="outlined" className="course-filter-elem"> StudentId</Button>
        <Button variant="outlined" className="course-filter-elem"> Student Name</Button>
        <Button variant="outlined" className="course-filter-elem"> Course</Button>
     
      </div>
    </div>



<table className = " zindex table table-striped table-bordered">

 <thead>
    <tr>
        <th>StudentID</th>
        <th>StudentName</th>
        <th>EnrolledCourse</th>
        <th> MobileNumber</th>
        <th> Actions</th>
    </tr>
 </thead>
 <tbody>
      <tr>

        <td>abhash </td>   
        <td>kumar </td>
        <td>abcdef </td>
        <td>avhds</td>
        <td>     
        <Link   to="/admin/EditUser" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
        <Button  variant="contained" style={{margin:"5px"}} endIcon={<Edit />} color="primary">Update </Button>
        </Link>                                   
       
        <Button  variant="contained"  color="error" endIcon={<Delete />}  >Delete</Button>                                         
        </td>

      </tr>
  </tbody>
</table>
<div className='btnadd'>
<Link   to="/admin/AddUser" style={{color:"white",textDecoration:"none"}}  target={"_blank"}>
<Button  variant="contained" style={{margin:"5px"}} startIcon={<Add />} color="primary">Add Student </Button> 
  </Link>
  </div>
   <Outlet />
</div>


        
    );
}
export default DisplayUser;