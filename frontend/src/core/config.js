const config = {
  COORDS: {
    CHQ: [53.3480395, -6.2479207],
    MAYOR_SQUARE: [53.34899, -6.244703],
    STREET_VIEW: [53.349325, -6.243713]
  },
  MAPS: {
    KEY: 'AIzaSyABKJoMXNrU4q7HyUMrpioXUCz9W83n6R4'
  },
  API_HOST: '//glacial-peak-56054.herokuapp.com',
  API: {
    PROPERTIES:
      '/homeland/api/properties?accountid=fa9df4d3-93bb-449a-9ee8-45b4c98d34b4&extraincome=220',
    ACCOUNTS:
      '/homeland/api/accounts?accountid=fa9df4d3-93bb-449a-9ee8-45b4c98d34b4&extraincome=220',
    AFFORDABILITY: 'homeland/api/affordability'
  }
};

export default config;
