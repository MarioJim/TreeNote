import './App.css';
import React, { Component, useState } from "react";
import Sidebar from './components/sidebar/sidebar'
import Main from "./components/Main/Main"


class App extends Component {
  constructor(props){
    super(props)

    this.state = {
      titleId : -1,
      titleContent : "TITLE",
      noteId : -1,
      noteContent : "preview note"
    }

    this.delta = this.delta.bind(this);
  }

  delta(titleId, titleContent, noteId, noteContent) {
    this.setState({
      titleId : titleId,
      titleContent : titleContent,
      noteId : noteId,
      noteContent : noteContent
    });
  }

  render(){

  const {titleId, titleContent, noteId, noteContent} = this.state

  return (
      <div className="App">
        <Sidebar activeNote={this.delta}/>
        <Main titleId={titleId} titleContent={titleContent} noteId={noteId} noteContent={noteContent}/> 
      </div>
  );
  }
}

export default App;
