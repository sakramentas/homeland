import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './styles.scss';
import Map from '../../components/Map';

class MapPage extends Component {
  render() {
    return (
      <div className="transition-item maps-page">
        <Map />
        <Link to="/street-view" className="nav-street-view">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="27"
            height="27"
            viewBox="0 0 16 16"
          >
            <path
              fill="#fff"
              fill-rule="evenodd"
              d="M9 13.917A6.005 6.005 0 0 0 13.917 9H11V7h2.917A6.005 6.005 0 0 0 9 2.083V5H7V2.083A6.005 6.005 0 0 0 2.083 7H5v2H2.083A6.005 6.005 0 0 0 7 13.917V11h2zM8 16A8 8 0 1 1 8 0a8 8 0 0 1 0 16zm0 0"
            />
          </svg>
        </Link>
      </div>
    );
  }
}

export default MapPage;
