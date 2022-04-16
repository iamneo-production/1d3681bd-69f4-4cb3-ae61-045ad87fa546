// import React, { Component } from 'react';
import "./EditAcademy.css";
import Header from "../Components/Header";
import Footer from "../Components/Footer";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";
import { padding } from "@mui/system";
import Add from "@mui/icons-material/Add";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  Outlet,
} from "react-router-dom";

import React, { useState } from "react";
import { getListSubheaderUtilityClass } from "@mui/material";

function EditAcademy(value1) {
  const [user, setUser] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [mobileNumber, setMobile] = useState("");
  const [password, setPassword] = useState("");
  const [id, setId] = useState(null);

  return (
    <div>
      <Header />
      <div className="enroll_form_container">
        <div className="enroll_form_container-below">
          <input
            required
            type="text"
            className="row1"
            value={name}
            onChange={(e) => {
              var letter = /^[a-zA-Z]*$/;
              let value;
              if (!e.target.value.match(letter)) {
                value = "";
              }
              setName(value);
            }}
            placeholder="Enter Academy name"
            id="academyName"
          ></input>

          <input
            required
            type="text"
            value={mobileNumber}
            onChange={(e) => {
              var num = /[^0-9]/gi;
              let value = e.target.value.replace(num, "");
              setMobile(value);
            }}
            className="row1"
            placeholder="Enter the contact number"
            id="contactNumber"
          ></input>

          <input
            required
            type="text"
            className="row1"
            value={""}
            placeholder="Enter the academy image url"
            id="imageUrl"
          ></input>

          <input
            required
            type="email"
            value={email}
            className="row1"
            placeholder="Enter the academy email"
            id="emailId"
          ></input>

          <input
            required
            type="text"
            className="row1"
            placeholder="Enter academy location"
            id="academyLocation"
          ></input>

          <textarea
            required
            className="row1"
            placeholder="Enter academy description"
            id="academyDescription"
          ></textarea>

          <div className="row1">
            <Button
              variant="contained"
              style={{ margin: "5px" }}
              startIcon={<Add />}
              color="primary"
            >
              EditAcademy Academy{" "}
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default EditAcademy;
