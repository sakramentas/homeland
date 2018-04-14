import React from 'react';

const Marker = ({ title, price }) => (
  <div
    style={{
      background: `red`,
      color: `white`,
      padding: 5
    }}
  >
    {title} {price}
  </div>
);

export default Marker;
