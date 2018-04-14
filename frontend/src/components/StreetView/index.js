import React from 'react';
import axios from 'axios';
import { compose, withProps } from 'recompose';
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  StreetViewPanorama,
  OverlayView
} from 'react-google-maps';

import Overlay from './Marker';
import config from '../../core/config';

import './street-view.css';

const [lat, lng] = config.COORDS.MAYOR_SQUARE;

const StreetViewPanormaWithAnOverlayView = compose(
  withProps({
    googleMapURL: `https://maps.googleapis.com/maps/api/js?key=${
      config.MAPS.KEY
    }&v=3.exp&libraries=geometry,drawing,places`,
    loadingElement: <div style={{ height: `100%` }} />,
    containerElement: <div className="streetViewWrap" />,
    mapElement: <div className="streetViewWrap" />,
    center: { lat, lng }
  }),
  withScriptjs,
  withGoogleMap
)(({ center, properties }) => (
  <GoogleMap defaultZoom={8} defaultCenter={center}>
    <StreetViewPanorama defaultPosition={center} visible>
      <Overlay properties={properties} />
    </StreetViewPanorama>
  </GoogleMap>
));

export default class Map extends React.PureComponent {
  state = {
    properties: []
  };

  async componentDidMount() {
    const { data } = await axios.get(
      `${config.API_HOST}${config.API.PROPERTIES}`
    );

    this.setState({ properties: data.properties });
  }

  handleMarkerClick = () => {
    this.setState({ isMarkerShown: false });
    this.delayedShowMarker();
  };

  render() {
    return (
      <StreetViewPanormaWithAnOverlayView properties={this.state.properties} />
    );
  }
}
