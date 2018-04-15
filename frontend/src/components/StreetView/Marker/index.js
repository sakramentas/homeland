import React from 'react';
import { withRouter } from 'react-router';
import { OverlayView } from 'react-google-maps';

import './marker.css';

const getAptNum = address => address.match(/\d+/)[0];

const getPixelPositionOffset = aptNum => (width, height) => ({
  x: -(width / 2),
  y: -(height * (aptNum / 40))
});

const colors = color =>
  ({ green: '#549638', amber: '#CC7723', red: '#D33737' }[color || 'green']);

const Marker = ({
  id,
  title,
  floorArea,
  price = 0,
  affordabilityStatus = 'green',
  history
}) => (
  <div
    className="markerItemWrap"
    style={{ background: colors(affordabilityStatus) }}
    onClick={() => {
      console.log(history);
      history.push(`/property/${id}`);
    }}
  >
    <div className="priceCon">€{price.toLocaleString()}</div>
    <span>
      {floorArea}m<sup>2</sup>
    </span>
  </div>
);

const MarkerComp = ({ properties, history }) => {
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
        <Marker {...property} history={history} />
      </OverlayView>
    );
  });
};

export default withRouter(MarkerComp);
