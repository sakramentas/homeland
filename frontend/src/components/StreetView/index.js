import React from 'react';
import { compose, withProps } from 'recompose';
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  Marker,
  StreetViewPanorama,
  OverlayView
} from 'react-google-maps';

import MarkerComp from './Marker';

import config from '../../core/config';

const [lat, lng] = config.COORDS.MAYOR_SQUARE;

const getPixelPositionOffset = (width, height) => ({
  x: -(width / 2),
  y: -(height / 2)
});

const StreetViewPanormaWithAnOverlayView = compose(
  withProps({
    googleMapURL: `https://maps.googleapis.com/maps/api/js?key=${
      config.MAPS.KEY
    }&v=3.exp&libraries=geometry,drawing,places`,
    loadingElement: <div style={{ height: `100%` }} />,
    containerElement: <div style={{ height: `400px` }} />,
    mapElement: <div style={{ height: `100%` }} />,
    center: { lat, lng }
  }),
  withScriptjs,
  withGoogleMap
)(props => (
  <GoogleMap defaultZoom={8} defaultCenter={props.center}>
    <StreetViewPanorama defaultPosition={props.center} visible>
      {config.HOUSES.map(({ lat, lng, title, price }, i) => (
        <OverlayView
          key={i}
          position={{ lat, lng }}
          mapPaneName={OverlayView.OVERLAY_LAYER}
          getPixelPositionOffset={getPixelPositionOffset}
        >
          <MarkerComp title={title} price={price} />
        </OverlayView>
      ))}
    </StreetViewPanorama>
  </GoogleMap>
));

export default class Map extends React.PureComponent {
  state = {
    isMarkerShown: false
  };

  componentDidMount() {
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
    return <StreetViewPanormaWithAnOverlayView />;
  }
}
