import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import Layout from "./components/Layout";
import AdminInstitute from "./components/Admininstitute";
import Admincourse from "./components/Admincourse";
import AdminStudents from "./components/Adminstudents";
import CourseEdit from "./components/CourseEdit";
import Nopage from "./components/Nopage";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<AdminInstitute />} />
            <Route path="viewcourse" element={<Admincourse />} />
            <Route path="viewinstitute" element={<AdminInstitute />} />
            <Route path="viewstudents" element={<AdminStudents />} />
            <Route path="viewcourse/course-edit" element={<CourseEdit />} />

            <Route path="*" element={<Nopage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
