import Home from '../pages/Home';
import StreetView from '../pages/StreetView';

const Routes = [
  { path: '/', exact: true, component: Home },
  { path: '/street-view', exact: true, component: StreetView }
];

export default Routes;
