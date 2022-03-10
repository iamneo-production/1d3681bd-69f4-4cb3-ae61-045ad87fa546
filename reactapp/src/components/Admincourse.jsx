import React from "react";
import CourseCard from "./CourseCard";
import CourseSearchFilter from "./CourseSearchFilter";
import CourseEdit from "./CourseEdit";
import { Route, Routes } from "react-router-dom";

function Admincourse() {
  return (
    <div className="container-course">
      {/*course header start*/}
      <CourseSearchFilter />
      {/*course header ends here*/}
      <CourseCard />
      <CourseCard />

      <button id="addCourse" className="addcourse-btn btn">
        {" "}
        Add Course
      </button>
    </div>
  );
}

export default Admincourse;
