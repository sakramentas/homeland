import Home from '../pages/Home';
import Maps from '../pages/Maps';
import StreetView from '../pages/StreetView';

const Routes = [
  { path: '/', exact: true, component: Home },
  { path: '/maps', exact: true, component: Maps },
  { path: '/street-view', exact: true, component: StreetView }
];

export default Routes;
