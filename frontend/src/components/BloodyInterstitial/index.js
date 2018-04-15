import React from 'react';

import './interstitial.css';

const Interstitial = ({ show }) => (
  <div className={`interstitialWrapper ${show ? 'show' : ''}`}>
    <img src="https://image.ibb.co/fEE7SS/INTERSTITIAL.gif" alt="interstitial"/>
    <span>Finding the best properties based on your collected data</span>
  </div>
);

export default Interstitial;
