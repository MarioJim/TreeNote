import './App.css';
import React from "react";
import Sidebar from './Sidebar';
import NotesList from './components/NotesList';
import Book from './components/Book';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {
    
  return (
    <Router>
      <div className="App">
        <div style={{ display: 'flex', height: '100vh', overflow: 'scroll initial'}}>
          <Sidebar/>
          <div className="switch">
          <Switch>
            <Route path='/' exact component={Book} />
          </Switch>
          </div>
        </div>
      </div>
    </Router>
  );
}

export default App;
