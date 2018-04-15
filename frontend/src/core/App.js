import React, { Component } from 'react';
import { Route, Switch } from 'react-router-dom';
import PageTransition from 'react-router-page-transition';
import Header from '../components/Header/index';
import routes from './routes';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header />
        <PageTransition timeout={1000}>
          <Switch location={this.props.location}>
            {routes.map(route => <Route {...route} key={route.path} />)}
          </Switch>
        </PageTransition>
      </div>
    );
  }
}

export default App;
