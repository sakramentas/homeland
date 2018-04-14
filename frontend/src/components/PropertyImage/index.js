import React from 'react';
import './styles.css';

const PropertyImage = () => {
  return (
    <div className="property-image">
      <img src={require('../../assets/house.png')} alt="house"/>
      <span className="property-image__explore">Exploree around</span>
    </div>
  );
};

export default PropertyImage;
