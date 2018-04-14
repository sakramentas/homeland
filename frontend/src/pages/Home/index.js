import React, { Component } from 'react';
import {  withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"
import './styles.css';
import Map from '../../components/Map';

class MapPage extends Component {
  render() {
    return (
      <div className="App">
        <Map isMarkerShown />
      </div>
    );
  }
}

export default MapPage;
