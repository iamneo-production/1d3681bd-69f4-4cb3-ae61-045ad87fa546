import React from 'react';
import HeaderStudent from '../Components/HeaderStudent';
import "./Review.css"

function Review(props) {
    return (
        <div>
            <HeaderStudent/>
            <div className="card">
  {/* <img src="img_avatar.png"  style={{width:"100%"}}/> */}
 
  <div className="container">
    <h4><b>John Doe</b></h4> 
    <p>Architect & Engineer</p> 
  </div>
</div>
        </div>
    );
}

export default Review;