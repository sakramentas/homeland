import Home from '../pages/Home';
import App from '../core/App';
import Maps from '../pages/Maps';
import StreetView from '../pages/StreetView';
import ChatbotPage from '../pages/Chatbot';
import PropertyPage from '../pages/Property';

const Routes = [
  { path: '/', exact: true, component: ChatbotPage },
  { path: '/maps', exact: true, component: Maps },
  { path: '/street-view', exact: true, component: StreetView },
  { path: '/chatbot', exact: true, component: ChatbotPage },
  { path: '/property/:id', exact: true, component: PropertyPage }
];

export default Routes;
