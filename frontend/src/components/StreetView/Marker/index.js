import React from 'react';
import { OverlayView } from 'react-google-maps';

import './marker.css';

const getAptNum = address => address.match(/\d+/)[0];

const getPixelPositionOffset = aptNum => (width, height) => ({
  x: -(width / 2),
  y: -(height * (aptNum / 40))
});

const Marker = ({ title, floorArea, price = 0 }) => (
  <div className="markerItemWrap">
    <div className="priceCon">€{price.toLocaleString()}</div>
    <span>
      {floorArea}m<sup>2</sup>
    </span>
  </div>
);

export default ({ properties }) => {
  const onlyFive = properties.splice(0, 5);
  return onlyFive.map((property, i) => {
    const {
      geo: { lat, lng },
      address
    } = property;
    return (
      <OverlayView
        key={i}
        position={{ lat, lng }}
        mapPaneName={OverlayView.OVERLAY_LAYER}
        getPixelPositionOffset={getPixelPositionOffset(~~getAptNum(address))}
      >
        <Marker {...property} />
      </OverlayView>
    );
  });
};
