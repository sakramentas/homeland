import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import routes from './routes';

import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Homeland</h1>
        </header>
        <BrowserRouter>
          <Switch>
            {routes.map(route => <Route {...route} key={route.path} />)}
          </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
