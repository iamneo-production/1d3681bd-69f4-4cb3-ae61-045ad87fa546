import React from "react";
import { Route, Routes } from "react-router-dom";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import { Link } from "react-router-dom";

function CourseCard() {
  return (
    <div id="courseGrid" className="courseGrid">
      <div className="course-card">
        <div className="course-info-1">
          <div className="course-info-1-elem">Course Id</div>
          <div className="course-info-1-elem">Students Enrolled:</div>
        </div>
        <div className="course-info-2">
          <div className="course-info-2-elem">
            <span className="course-info-2-elem-span">Course Name</span>{" "}
            <span className="course-info-2-elem-span">Duration</span>
          </div>
          <div className="course-info-2-elem">
            <span className="course-info-2-elem-span">Course Year</span>{" "}
            <span className="course-info-2-elem-span">Type</span>
          </div>

          <div className="course-info-2-institute">
            <span>Institute Name</span>
          </div>
        </div>

        <div className="course-info-3">
          {/* <button className="btn">Enroll</button> */}
          <div className="course-info-3-elem">
            <button id="editCourse" className="btn-lite">
              <Link to="course-edit">
                <EditIcon />
                Edit
              </Link>
            </button>
            <button id="deleteCourse" className="btn-lite ">
              <DeleteIcon /> Delete
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
export default CourseCard;
