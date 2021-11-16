import './App.css';
import React from "react";
import Sidebar from "./components/sidebar/sidebar"
import Main from "./components/Main/Main"
import Book from './components/Book';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {
  
  
  return (
    <Router>
      <div className="App">
        
        <Sidebar/>
        <Main/>
      </div>
    </Router>
  );
}

export default App;
