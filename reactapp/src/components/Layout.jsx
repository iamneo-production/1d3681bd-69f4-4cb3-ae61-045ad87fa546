import React from "react";
import { Outlet, Link } from "react-router-dom";
import Navbar from "./Navbar";
import OptionsBelowNav from "./OptionsBelowNav";
import Footer from "./Footer";

function Layout() {
  return (
    <>
      <Navbar />
      <OptionsBelowNav />
      <Outlet />
      <Footer />
    </>
  );
}

export default Layout;
