import './App.css';
import React, { Component, useState } from "react";
import Sidebar from './components/sidebar/sidebar'
import Main from "./components/Main/Main"


class App extends Component {
  constructor(props){
    super(props)

    this.state = {
      activeTitleId : "TITLE",
      activeContentId : "preview note"
    }

    this.delta = this.delta.bind(this);
  }

  delta(idTitle, idContent) {
    this.setState({
      activeTitleId : idTitle,
      activeContentId : idContent
    });
  }

  render(){

  const {activeTitleId, activeContentId} = this.state

  function activeNote(idTitle, idContent){
    console.log("title", idTitle)
    console.log("content", idContent)
    this.delta(idTitle)
  }

  return (
      <div className="App">
        <Sidebar activeNote={this.delta}/>
        <Main activeTitleId={activeTitleId} activeContentId={activeContentId}/> 
      </div>
  );
  }
}

export default App;
