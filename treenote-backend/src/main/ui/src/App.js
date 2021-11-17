import './App.css';
import React, { useState } from "react";
import Sidebar from './components/sidebar/sidebar'
import Main from "./components/Main/Main"


function App() {

  function activeNote(idTitle, idContent){
    console.log("title", idTitle)
    console.log("content", idContent)
  }

  return (
      <div className="App">
        <Sidebar activeNote={activeNote}/>
        <Main/> 
      </div>
  );
}

export default App;
