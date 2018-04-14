import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import PropertyImage from '../../components/PropertyImage';
import PropertyTag from '../../components/PropertyTag';
import PropertyInfo from '../../components/PropertyInfo';
import PropertyAdditionals from '../../components/PropertyAdditionals';
import './styles.css';

class PropertyPage extends Component {
  render() {
    return (
      <div className="transition-item property-page">
        <PropertyImage/>
        <span className="property-name">The CHQ building, Custom House, Dublin 1</span>
        <PropertyTag/>
        <PropertyInfo/>
        <PropertyAdditionals/>
        <span className="property-price">£300,000</span>
        <button className="property-button">I'm interested</button>
      </div>
    );
  }
}

export default PropertyPage;
