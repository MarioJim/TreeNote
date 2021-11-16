import React, { useState } from "react";
import "./sidebar.css";
import { BrowserRouter as Router, Switch, Route, Link, useHistory, NavLink } from 'react-router-dom';
import Book from "../Book"
import Page from "../Page";
import Note from "../Note"

function Sidebar() {  

  
  return (
    <div className='app-sidebar'>
      <div className="app-sidebar-header">
        <h1>Notes</h1>
        <button className="app-sidebar-Add-Button">Add</button>
      </div>
      <div className="app-sidebar-notes">
      <Router>
        <Switch>
              <Route path='/' exact component={Book}/>
              <Route path='/pages/:id' exact component={Page}></Route>
        </Switch>
      </Router>
        
      </div>
    </div>
  );
}

export default Sidebar;