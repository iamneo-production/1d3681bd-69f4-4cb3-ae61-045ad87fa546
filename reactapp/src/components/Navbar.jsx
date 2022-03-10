import React from "react";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import LogoutIcon from "@mui/icons-material/Logout";

function Navbar() {
  return (
    <header className="container-nav">
      <div className="nav-logo">
        <span> PG Admission</span>
      </div>
      <div className="nav">
        <div className="nav-logout">
          <LogoutIcon sx={{ fontSize: 35 }} /> <div>logout</div>
        </div>
        <div className="nav-profile">
          <AccountCircleIcon sx={{ fontSize: 35 }} />
          <div>Profile</div>
        </div>
      </div>
    </header>
  );
}

export default Navbar;
