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

    async function addData(){
      if ( document.URL.includes("pages") ) {
        const book = {title : "Untitle book"}
        axios.post('http://localhost:3000/api/books/new', book)
        .then(response => console.log(response))
      }
      else {
      //   const book = {title : "Untitle book"}
      //   axios.post('http://localhost:3000/api/books/new', book)
      //   .then(response => console.log(response))
      // }
      console.log("asd")
      }
    }

  return (
    <div className='app-sidebar'>
      <div className="app-sidebar-header">
        <h1>Notes</h1>
        <button onClick={() => addData()} className="app-sidebar-Add-Button">Add</button>
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
  )}
}

export default Sidebar;