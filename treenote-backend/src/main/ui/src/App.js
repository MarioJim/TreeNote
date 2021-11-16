import './App.css';
import React, { useState } from "react";
import Sidebar from "./components/sidebar/sidebar"
import Main from "./components/Main/Main"

function App() {

  return (
      <div className="App">
        <Sidebar/>
        <Main/> 
      </div>
  );
}

export default App;
