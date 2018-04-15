import React from 'react';

import './interstitial.css';

const Interstitial = ({ show }) => (
  <div className={`interstitialWrapper ${show ? 'show' : ''}`}>Icon</div>
);

export default Interstitial;
