import Home from '../pages/Home';
import App from '../core/App';
import Maps from '../pages/Maps';
import StreetView from '../pages/StreetView';
import ChatbotPage from '../pages/Chatbot';

const Routes = [
  { path: '/', exact: true, component: Maps },
  { path: '/maps', exact: true, component: Maps },
  { path: '/street-view', exact: true, component: StreetView },
  { path: '/chatbot', exact: true, component: ChatbotPage },
];

export default Routes;
