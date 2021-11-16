import React, { useState } from "react";
import "./sidebar.css";
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Book from "../Book"
import Page from "../Page";

function Sidebar() {

  return (
    <div className='app-sidebar'>
      <div className="app-sidebar-header">
        <h1>Notes</h1>
        <button className="app-sidebar-Add-Button">Add</button>
      </div>
      
      <button className="app-sidebar-Change-Button">Books</button>
      <button className='app-sidebar-Change-Button'>Pages</button>
      <button className='app-sidebar-Change-Button'>Notes</button>
      <div className="app-sidebar-notes">

      <Router>
        <Switch>
              <Route path='/' exact component={Book} />
              <Route path='/pages' exact component={Page}/>
        </Switch>
      </Router>
        
      </div>
    </div>
  );
}

export default Sidebar;