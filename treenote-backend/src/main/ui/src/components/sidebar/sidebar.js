import React, { Component, useState } from "react";
import "./sidebar.css";
import { BrowserRouter as Router, Switch, Route, Link, useHistory, NavLink } from 'react-router-dom';
import Book from "../Book/Book"
import Page from "../Page";
import axios from "axios";

class Sidebar extends Component {
  constructor(props){
    super(props)
  }

  render(){

    async function addData(activeNote){
      if ( document.URL.includes("pages") ) {
        var parentId = parseInt(document.URL.split(/[/ ]+/).pop())-1;
        const noteTitle = {parent_id: parentId, note_type : "TextNote", content : "Untitle Note"}
        axios.post('http://localhost:3000/api/notes/new', noteTitle)
        .then(response => window.location.reload())
      }
      else {
        const book = {title : "Untitle book"}
        axios.post('http://localhost:3000/api/books/new', book)
        .then(response => window.location.reload())
      }
    }

  return (
    <div className='app-sidebar'>
      <div className="app-sidebar-header">
        <h1>Notes</h1>
        <button onClick={() => addData(this.props.activeNote)} className="app-sidebar-Add-Button">Add</button>
      </div>
      <div className="app-sidebar-notes">
      <Router>
        <Switch>
              <Route path='/' exact component={Book}/>
              <Route path='/pages/:id' render={(props) => <Page {...props} activeNote={this.props.activeNote}/>}></Route>
        </Switch>
      </Router>
        
      </div>
    </div>
  )}
}

export default Sidebar;