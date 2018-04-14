import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import PageTransition from 'react-router-page-transition';
import { TransitionGroup, CSSTransition } from "react-transition-group";
import routes from './routes';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img
            src={require('../assets/logo-02.png')}
            alt=""
            className="header-logo"
          />
        </header>
          <PageTransition timeout={1000}>
            <Switch location={this.props.location}>
              {routes.map(route => (
                <Route {...route} key={route.path}/>
              ))}
            </Switch>
          </PageTransition>
      </div>
    );
  }
}

export default App;
