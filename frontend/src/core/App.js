import React, { Component } from 'react';
import { BrowserRouter, browserHistory, Route, Switch } from 'react-router-dom';

import routes from './routes';

import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <BrowserRouter history={browserHistory}>
          <Switch>
            {routes.map(route => <Route {...route} key={route.path} />)}
          </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
