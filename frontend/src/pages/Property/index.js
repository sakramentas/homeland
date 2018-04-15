import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import PropertyImage from '../../components/PropertyImage';
import PropertyTag from '../../components/PropertyTag';
import PropertyInfo from '../../components/PropertyInfo';
import PropertyAdditionals from '../../components/PropertyAdditionals';
import config from '../../core/config';

import './styles.css';

class PropertyPage extends Component {
  state = {
    property: 1
  };

  getProperty(properties) {
    const { id } = this.props.match.params;

    return properties.find(property => property.id === ~~id);
  }

  async componentDidMount() {
    const { data } = await axios.get(
      `${config.API_HOST}${config.API.PROPERTIES}`
    );
    this.setState({ property: this.getProperty(data.properties) });
  }
  render() {
    const { picture, address, price } = this.state.property;
    return (
      <div className="transition-item property-page">
        <PropertyImage url={picture} />
        <span className="property-name">{address}</span>
        <PropertyTag {...this.state.property} />
        <PropertyInfo />
        <PropertyAdditionals />
        <span className="property-price">€{price}</span>
        <button className="property-button">I'm interested</button>
      </div>
    );
  }
}

export default PropertyPage;
