import React from 'react';
import './styles.css';

const PropertyTag = ({ affordabilityStatus }) => {
  const affordabilityMessage = {
    green: 'The property matches your profile',
    amber: 'The property is close to match your profile',
    red: 'The property does not match your profile',
  }[affordabilityStatus];

  return (
    <div className={`property-tag ${affordabilityStatus}`}>
      <span>{affordabilityMessage}</span>
    </div>
  );
};

export default PropertyTag;
