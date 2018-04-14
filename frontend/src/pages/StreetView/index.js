import React, { Component } from 'react';

import './styles.css';
import StreetView from '../../components/StreetView';

class MapPage extends Component {
  render() {
    return (
      <div className="App">
        <StreetView />
      </div>
    );
  }
}

export default MapPage;
