import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import './styles.scss';
import Map from '../../components/Map';

class MapPage extends Component {
  render() {
    return (
      <div className="transition-item maps-page">
        <Link to={`/chatbot`} className="list-item">
          <span>chatbot</span>
        </Link>
        <Map />
      </div>
    );
  }
}

export default MapPage;
