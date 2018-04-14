import React from 'react';
import './header.css';

const Header = () => {
  return (
    <div className="header">
      <img
        src={require('../../assets/logo_white-04.png')}
        alt=""
        className="header-logo"
      />
    </div>
  );
};

export default Header;
