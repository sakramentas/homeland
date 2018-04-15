import React from 'react';
import { Link } from 'react-router-dom';
import { slide as Menu } from 'react-burger-menu'

import './header.css';

const Header = () => {
  return (
    <div className="header">
      <Menu className="hamburger">
        <a id="home" className="menu-item" href="/">Home</a>
        <a id="map" className="menu-item" href="/chatbot">Chatbot</a>
        <a id="chatbot" className="menu-item" href="/maps">Map</a>
        <a onClick={() => console.log('settings') } className="menu-item--small" href="">Settings</a>
      </Menu>
      <img
        src={require('../../assets/logo_white-04.png')}
        alt=""
        className="header-logo"
      />
      <Link to="/maps" className="nav-next" />
    </div>
  );
};

export default Header;
