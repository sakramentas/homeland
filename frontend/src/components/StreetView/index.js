import React from 'react';
import ReactStreetview from 'react-streetview';

import config from '../../core/config';

import './street-view.css';

class StreetView extends React.Component {
  render() {
    const [lat, lng] = config.COORDS.CHQ;
    const streetViewPanoramaOptions = {
      position: { lat, lng },
      pov: { heading: 100, pitch: 0 },
      zoom: 1
    };

    return (
      <div className="streetViewWrap">
        <ReactStreetview
          apiKey={config.API.MAPS}
          streetViewPanoramaOptions={streetViewPanoramaOptions}
        />
      </div>
    );
  }
}

export default StreetView;
