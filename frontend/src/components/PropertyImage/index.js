import React from 'react';
import './styles.css';

const PropertyImage = ({ url }) => {
  return (
    <div className="property-image">
      <img src={url} alt="house" />
      <span className="property-image__explore">Explore around</span>
    </div>
  );
};

export default PropertyImage;
