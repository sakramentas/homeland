import React from 'react';
import { compose, withProps } from 'recompose';
import axios from 'axios';
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  Marker
} from 'react-google-maps';
import HeatmapLayer from 'react-google-maps/lib/components/visualization/HeatmapLayer';

import config from '../../core/config';

const [lat, lng] = config.COORDS.CHQ;

const MyMapComponent = compose(
  withProps({
    googleMapURL: `https://maps.googleapis.com/maps/api/js?key=${
      config.MAPS.KEY
    }&v=3.exp&libraries=geometry,drawing,places,visualization`,
    loadingElement: <div style={{ height: `100%` }} />,
    containerElement: <div style={{ height: `100%` }} />,
    mapElement: <div style={{ height: `100%` }} />
  }),
  withScriptjs,
  withGoogleMap
)(({ properties, isMarkerShown, onMarkerClick }) => (
  <GoogleMap defaultZoom={14} defaultCenter={{ lat, lng }}>
    {isMarkerShown &&
      properties.map(({ geo: { lat, lng } }) => (
        <Marker
          position={{ lat, lng }}
          onClick={onMarkerClick}
          icon="https://maps.google.com/mapfiles/kml/shapes/parking_lot_maps.png"
        />
      ))}
  </GoogleMap>
));

export default class Map extends React.PureComponent {
  state = {
    isMarkerShown: true,
    properties: []
  };

  async componentDidMount() {
    const { data } = await axios.get(
      `${config.API_HOST}${config.API.PROPERTIES}`
    );

    this.setState({ properties: data.properties });
    this.delayedShowMarker();
  }

  delayedShowMarker = () => {
    setTimeout(() => {
      this.setState({ isMarkerShown: true });
    }, 3000);
  };

  handleMarkerClick = () => {
    this.setState({ isMarkerShown: false });
    this.delayedShowMarker();
  };

  render() {
    return (
      <MyMapComponent
        properties={this.state.properties}
        isMarkerShown={this.state.isMarkerShown}
        onMarkerClick={this.handleMarkerClick}
      />
    );
  }
}
