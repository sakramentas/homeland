import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import './styles.css';

class PropertyPage extends Component {
  render() {
    return (
      <div className="transition-item property-page">
        <div className="property-image">
          <img src={require('../../assets/house.png')} alt="house"/>
          <span className="property-image__explore">Exploree around</span>
        </div>
        <span className="property-name">The CHQ building, Custom House, Dublin 1</span>
        <div className="property-tag">
          <span>The property matches your profile</span>
        </div>
        <div className="property-info"></div>
        <div className="property-info-additionals"></div>
        <span className="property-price">£300,000</span>
        <button className="property-button">I'm interested</button>
      </div>
    );
  }
}

export default PropertyPage;
