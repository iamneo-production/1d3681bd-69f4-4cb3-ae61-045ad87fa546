import React from "react";
import { Link } from "react-router-dom";

function OptionsBelowNav() {
  return (
    <div className="container-below-nav ">
      <div className="options-below-nav">
        <div className="options-below-nav-items ">
          <Link className="options-institute" to="/viewinstitute">
            Institute
          </Link>
        </div>
        <div className="options-below-nav-items ">
          <Link className="options-courses" to="/viewcourse">
            Courses
          </Link>{" "}
        </div>
        <div className="options-below-nav-items ">
          <Link className="options-students" to="/viewstudents">
            Students
          </Link>{" "}
        </div>
      </div>
    </div>
  );
}
export default OptionsBelowNav;
