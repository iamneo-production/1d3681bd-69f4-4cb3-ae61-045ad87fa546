// import { Search } from '@mui/icons-material';
// import { Button, CardActions, CardContent,CardHeader, CardMedia, Typography } from '@mui/material';
import "./Card.css";

import React from 'react';
import { Button } from "@mui/material";
import { Delete, Edit, Reviews, Search } from "@mui/icons-material";
import { Link } from "react-router-dom";

function Card(props) {
    return (
        <div>
           <div className="card">
  <img src="https://images.unsplash.com/photo-1621640786029-220e9ff8dd09?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80" 
   style={{width:"100%"}}/>
  <div className="container">
    <h4><b>R.k Institute of Technology</b></h4> 
    <p>Premier institute in engineering</p> 
  </div>
  <div> <Button style={{marginLeft:"60px",marginBottom:"10px",zIndex:-1}} startIcon={<Reviews/>}>Reviews</Button></div>
  <div>
  <Link to="/admin/Edit"  style={{color:"white", textDecoration:"none"} } underline='none'>
      <Button  style={{zIndex:-1}} startIcon={<Edit/>} variant="outlined">Edit</Button>
      </Link>
     
      <Button startIcon={<Delete/>}  style={{marginLeft:"30px",zIndex:-1}} variant="outlined">Delete</Button>
  </div>
</div>

           
        </div>
    );
}

export default Card;