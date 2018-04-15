import React from 'react';
import { Link } from 'react-router-dom';

import './header.css';

const Header = () => {
  return (
    <div className="header">
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
