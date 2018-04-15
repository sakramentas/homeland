import React from 'react';

import './interstitial.css';

const Interstitial = ({ show }) => (
  <div className={`interstitialWrapper ${show ? 'show' : ''}`}>
    <img src={require('../../assets/interstitial.gif')} alt="interstitial"/>
    <span>Finding the best properties based on your data</span>
  </div>
);

export default Interstitial;
