import React from 'react';
import { OverlayView } from 'react-google-maps';

import './marker.css';

const getAptNum = address => address.match(/\d+/)[0];

const getPixelPositionOffset = aptNum => (width, height) => ({
  x: -(width / 2),
  y: -(height * (aptNum / 20))
});

const Marker = ({ title, price, floorArea }) => (
  <div className="markerItemWrap">
    <div className="priceCon">€{price},000</div>
    <span>
      {floorArea}m<sup>2</sup>
    </span>
  </div>
);

export default ({ properties }) => {
  const onlyFive = properties.splice(0, 8);
  return onlyFive.map((property, i) => {
    const {
      geo: { lat, lng },
      address,
      price
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
