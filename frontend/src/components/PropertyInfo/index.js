import React from 'react';
import './styles.css';

const PropertyInfo = (props) => {
  return (
    <div className="property-info">
      <div className="property-info__house-type">
        <img src={require('../../assets/house-icon.png')} alt=""/>
        <span>Detached house</span>
      </div>
      <div className="property-info__bedrooms">
        <img src={require('../../assets/bed.png')} alt=""/>
        <span>2 Bedrooms</span>
      </div>
      <div className="property-info__bathrooms">
        <img src={require('../../assets/bathtub.png')} alt=""/>
        <span>1 Bathroom</span>
      </div>
    </div>
  );
};

export default PropertyInfo;
