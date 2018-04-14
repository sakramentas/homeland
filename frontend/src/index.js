import React from 'react';
import ReactDOM from 'react-dom';
import { Route, BrowserRouter } from 'react-router-dom';
import './core/App.scss';
import App from './core/App';
import registerServiceWorker from './core/registerServiceWorker';

const AppWrapper = () => (
  <BrowserRouter>
    <Route path="/" component={App} />
  </BrowserRouter>
);

ReactDOM.render(<AppWrapper/>, document.getElementById('root'));
registerServiceWorker();
