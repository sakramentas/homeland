import React, { Component } from 'react';
import './App.css';
import MapPage from './pages/map';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Homeland</h1>
        </header>
        <MapPage/>
      </div>
    );
  }
}

export default App;
