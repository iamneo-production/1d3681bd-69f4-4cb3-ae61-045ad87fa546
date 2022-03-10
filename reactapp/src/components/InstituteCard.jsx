import React from "react";
import DeleteIcon from "@mui/icons-material/Delete";
import SearchIcon from "@mui/icons-material/Search";

function InstituteCard() {
  return (
    <div className="institute-container">
      <div className="institute-card">
        <div className="institute-content">
          <h1>Heading</h1>
          <p>contents</p>
        </div>
        <div className="institute-btn-container">
          <button className="institute-btn institute-btn-view">
            <SearchIcon />
            VIEW
          </button>
          <button className="institute-btn">
            <DeleteIcon />
            DELETE
          </button>
        </div>
      </div>
    </div>
  );
}
export default InstituteCard;
