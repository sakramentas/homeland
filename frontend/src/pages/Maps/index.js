import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import './styles.scss';
import Map from '../../components/Map';

class MapPage extends Component {
  render() {
    return (
      <div className="transition-item maps-page">
        <Map />
        <Link to={`/chatbot`} className="list-item">
          <span>chatbot</span>
        </Link>
      </div>
    );
  }
}

export default MapPage;
