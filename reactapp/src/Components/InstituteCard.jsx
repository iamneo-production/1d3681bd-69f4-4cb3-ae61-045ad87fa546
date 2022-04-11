

import Button from '@mui/material/Button';

import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Delete from '@mui/icons-material/Delete';
import Search from '@mui/icons-material/Search';

import{BrowserRouter as Router, Routes,Route,Link,Outlet,} from "react-router-dom";


import Typography from '@mui/material/Typography';


function InstituteCard(){
    let cardstyle={
        width:"350px",
        height:"350px",
        backgroundColor:"rgb(219, 170, 213)",
        marginTop:"0",
        marginLeft:"60px",
        position:"relative",
        // bottom:"30px"

    };
    let card1={
      marginTop:"20px"
    };
    return(
        <div style={card1}>
            <Card style={cardstyle}
                  sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
                >
                  <CardMedia
                    component="img"
                    sx={{
                      // 16:9
                      pt: '50.25%',
                    }}
                    // image="https://source.unsplash.com/random"
                    // alt="random"
                  />
                  <CardContent sx={{ flexGrow: 1 }}>
                    <Typography gutterBottom variant="h5" style={{textAlign:"center"}} component="h2">
                      Heading
                    </Typography>
                    
                    <Typography style={{textAlign:"center"}}>
                      contents
                    </Typography>
                  </CardContent>
                  <CardActions>
                  <Link to="/admin/Edit"  style={{color:"white", textDecoration:"none"} } underline='none'>
                  <Button  startIcon={<Search/>} style={{marginLeft:"25px",marginRight:"40px"}} variant="outlined"  color="primary">
                    Edit
                    </Button>
                    </Link>
                    
                    <Button startIcon={<Delete />} style={{marginLeft:"25px",marginRight:"40px"}} variant="outlined"  color="error">
                    Delete
                    </Button>
                  </CardActions>
                </Card>
        </div>
    );
}
export default InstituteCard;