import React from 'react';
import ReactDOM from 'react-dom';
import './core/App.scss';
import App from './core/App';
import registerServiceWorker from './core/registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
