import React from 'react';
import './styles.css';

const PropertyAdditionals = (props) => {
  return (
    <div className="property-info-additionals">
      <span><img src={require('../../assets/thumb.png')} alt=""/>Parking Space</span>
      <span><img src={require('../../assets/thumb.png')} alt=""/>Gas Heating</span>
      <span><img src={require('../../assets/thumb.png')} alt=""/>Close to Work</span>
      <span><img src={require('../../assets/thumb.png')} alt=""/>Quite Neighboorhood</span>
    </div>
  );
};

export default PropertyAdditionals;
