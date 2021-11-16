import React, { useState } from "react";
import "./sidebar.css";
import plusIcon from "../../Assets/plus-icon.png"

function Sidebar() {

  return (
    <div className='app-sidebar'>
      <div className="app-sidebar-header">
        <h1>Notes</h1>
        <button className="app-sidebar-Add-Button">Add</button>
      </div>
      <div className="app-sidebar-notes">
        <div className="app-sidebar-note">
          <div className="sidebar-note-title">
            <strong>TITLE</strong>
            <button>Delete</button>
          </div>
          <p>Note preview</p>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;