import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import "./RowView.css";
import Delete from '@mui/icons-material/Delete';
import Edit from '@mui/icons-material/Edit';
import Link from '@mui/material/Link'
import Header from'../Components/Header';



function RowView() {
   

    let appbar1={
      
      padding:"1px",
      backgroundColor:"#CEA4B2",
      margin:"0px"
     
      
    };
    let toolbar1={
      height:"10px",
      color:"black",
      
    };

    return (
       <div>
         <Header/>
        <AppBar style={appbar1} className="appbar1" position="relative">
        <Toolbar style={toolbar1}>
          {/* <CameraIcon sx={{ mr: 2 }} /> */}
          
         <p className='heading1'> StudentID</p>
         <p className='heading'> StudentName</p>
         <p className='heading'> Enrolledcourse</p>
         <p className='heading'> MobileNumber</p>
        
         <div className='heading'>
          <Link href="#"   color="inherit" id="adminEditStudent" underline='none'><Edit/></Link>
          <Link href="#"  className='edit' id="adminDeleteStudent" color="black" underline='none'><Delete/></Link>
          </div>

        </Toolbar>

        
      </AppBar>
        </div>
    );
  }
  export default RowView;