import './App.css';
import React from 'react';
import {BrowserRouter as Router,Switch, Route} from 'react-router-dom';
import Nav from './Components/Nav';
import Home from './Components/Home';
import Properties from './Components/Properties';
import Favourites from './Components/Favourites';
import Auth from './Components/Auth';

function App() {
  return (
    <div className="App">
      <Router>
        <div className="app">
          <Nav/>
          <Switch>
            <Route path = "/" exact component= {Home}/>
            <Route path = "/properties" exact component= {Properties}/>
            <Route path = "/favourites" component= {Favourites}/>
            <Route path = "/Auth" component= {Auth}/>
          </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
