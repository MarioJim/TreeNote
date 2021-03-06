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
    async function addNote(id){
      const note = {parent_id: parseInt(id)-1, note_type: "TextNote", content: "Empty note"}
      axios.post('http://localhost:3000/api/notes/new', note)
      .then(response => window.location.reload())
    }

    async function addData(activeNote){
      if ( document.URL.includes("pages") ) {
        var bookId = parseInt(document.URL.split(/[/ ]+/).pop());
        const page = {book_id: bookId, title : "Untitle Note"}
        axios.post('http://localhost:3000/api/pages/new', page)
        .then(response => addNote(response.data.id))
      }
      else {
        var bookName = document.getElementById('bookName').value
        if(!bookName){bookName="Untitle book"}
        const book = {title : bookName}
        axios.post('http://localhost:3000/api/books/new', book)
        .then(response => window.location.reload())
      }
    }

  return (
    <div className='app-sidebar'>
      <div className="app-sidebar-header">
        <h1 onClick={()=> window.location.href = '/'} >Notes</h1>
        <button onClick={() => addData(this.props.activeNote)} className="app-sidebar-Add-Button">Add</button>
      </div>
      <input className='input-bookName' placeholder='book name' id='bookName'></input>
      <div className="app-sidebar-notes">
      <Router>
        <Switch>
              <Route path='/' key='root' exact component={Book}/>
              <Route path='/pages/:id' key='pages' render={(props) => <Page {...props} activeNote={this.props.activeNote}/>}></Route>
        </Switch>
      </Router>
        
      </div>
    </div>
  )}
}

export default Sidebar;