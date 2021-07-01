import './Style/App.css';
import React,{useEffect,useState} from 'react';
import {BrowserRouter as Router,Switch, Route} from 'react-router-dom';
import Nav from './Components/Nav';
import Home from './Components/Home';
import Properties from './Components/Properties';
import Favourites from './Components/Favourites';
import Auth from './Components/Auth';
import PropertyItem from './Components/PropertyItem'
import EditProfile from './Components/EditProfile'

function App() {

  return (
    <div className="App">
      <Router>
        <div className="container">
          <Nav/>
          <Switch>
            <Route path = "/" exact component= {Home}/>
            <Route path = "/properties" exact component= {Properties}/>
            <Route path = "/property/:id" component= {PropertyItem}/>
            <Route path = "/favourites" component= {Favourites}/>
            <Route path = "/Auth" component= {Auth}/>
            <Route path = "/Profile/Edit" component= {EditProfile}/>
          </Switch>
        </div>
      </Router>

    </div>
  );
}

export default App;
