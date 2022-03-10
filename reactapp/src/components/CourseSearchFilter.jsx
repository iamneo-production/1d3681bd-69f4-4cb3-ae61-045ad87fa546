import React, { useState } from "react";

function CourseSearchFilter() {
  return (
    <div className="course-search-and-filter">
      <div className="course-search">
        <input
          className="course-search-input"
          type="text"
          name="course"
          placeholder="Search Course"
        ></input>
        <button id="searchCourse" className="btn">
          Search
        </button>
      </div>
      <div className="course-filter">
        <div>Filter By</div>
        <div className="course-filter-elem">Location</div>
        <div className="course-filter-elem">Institute</div>
        <div className="course-filter-elem">Course</div>
      </div>
    </div>
  );
}
export default CourseSearchFilter;
