
import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';
// import InstituteCard from './Components/InstituteCard';
import HomePage from './Components/HomePage';
import DisplayUser from './AdminPages/DisplayUser';
import EditUser from './AdminPages/EditUser';
import AddUser from './AdminPages/AddUser';
import ErrorPage from './AdminPages/ErrorPage';
import AddAcademy from './AdminPages/AddAcademy';
import {render} from "react-dom";
// import Card from './Components/Card';
// import HeaderStudent from './Components/HeaderStudent';

import EditCourse from './AdminPages/EditCourse';
// import AddCourse from './Pages/AddCourse';
import ViewCourse from './AdminPages/ViewCourse';
import StudentInstitute from './UserPages/StudentInstitute';




import{BrowserRouter as Router, Routes,Route,} from "react-router-dom";
import AddCourse from './AdminPages/AddCourse';
import HeaderStudent from './Components/HeaderStudent';
import Course from './UserPages/Course';
import EnrollPage from './UserPages/EnrollPage';
import Login from './Pages/Login';
import Register from './Pages/Register';
import InstituteCard from './Components/InstituteCard';
import EditAcademy from './AdminPages/EditAcademy';
import Card from './Components/Card';
import Review from './UserPages/Review';
import EnrolledCourse from './UserPages/EnrolledCourse';


function App() {
  return (
    <div>
      {/* <Footer /> */}
      {/* <Header /> */}
      {/* <InstituteCard />  */}
       {/* <HomePage /> */}
      {/* <EditUser /> */}
      {/* <DisplayUser /> */}
      {/* <AddUser /> */}
      {/* render( */}
       
      {/* ); */}

        {/* <AddAcademy/> */}
        {/* <ViewCourse /> */}
        {/* <AddCourse /> */}
        {/* <EditCourse/> */}
        {/* <ViewCours/> */}
        {/* <HeaderStudent/>
        <StudentInstitute/>
        
        
        // <Card/>
       */}
       {/* <EnrolledCourse/> */}
       {/* <EnrollPage/> */}
       {/* <Card/> */}
       {/* <Card/> */}
       {/* <Review/> */}
      <Router>
      {/* <Header /> */}
        <Routes>
        <Route path='/Login' exact element={ <Login/> } />
       
          <Route path='/Register' exact element={ <Register/> } />
          <Route path="/" element={<HomePage/>}>

          
          </Route>

          <Route path="user/HomepageStudent" element={<StudentInstitute/>}/>
          <Route path="user/ViewCourse" element={<Course/>}/>
          <Route path="user/EnrollCourse" element={<EnrollPage/>}/>
          <Route path="user/EnrolledCourses" element={<EnrolledCourse/>}/>

          <Route path="user/Review" element={<Review/>}/>
          <Route path="admin/DisplayUser" element={<DisplayUser />} > 
           </Route>

           <Route path="admin/addAcademy" element={<AddAcademy />} > 
           </Route>
           <Route path="admin/ViewCourse" element={<ViewCourse />} > 
           </Route>
           <Route path="admin/AddUser" element={<AddUser />} > 
           </Route>
           
            <Route path="admin/AddCourses" element={<AddUser/>} >
            {/* <Route path="/adduser" element={<AddUser/>} ></Route> */}
            
            </Route>
            <Route path="admin/Edit" element={<EditAcademy /> }/>
            <Route path="admin/EditCourses" element={<EditCourse />} > 
           </Route>
           <Route path="admin/EditUser" element={<EditUser />} > 
           </Route>

           
           
            <Route path = "*" element = {<ErrorPage/>}></Route>
           
          
        </Routes>
        <Footer />
        </Router>
     
 
   
    </div>
  );
}

export default App;
