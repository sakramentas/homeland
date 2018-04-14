import React, { Component } from 'react';
import Map from '../../components/Map';
import './styles.css';
import StreetView from '../../components/StreetView';

class MapPage extends Component {
  render() {
    return (
      <div className="streetview-page transition-item">
        <StreetView />
      </div>
    );
  }
}

export default MapPage;
