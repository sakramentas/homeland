import React from "react"
import { compose, withProps } from "recompose"
import { withScriptjs, withGoogleMap, GoogleMap, Marker } from "react-google-maps"

const MyMapComponent = compose(
  withProps({
    googleMapURL: "https://maps.googleapis.com/maps/api/js?key=AIzaSyABKJoMXNrU4q7HyUMrpioXUCz9W83n6R4&v=3.exp&libraries=geometry,drawing,places",
    loadingElement: <div style={{ height: `100%` }}/>,
    containerElement: <div style={{ height: `100%` }}/>,
    mapElement: <div style={{ height: `100%` }}/>,
  }),
  withScriptjs,
  withGoogleMap
)((props) =>
  <GoogleMap
    defaultZoom={12}
    defaultCenter={{ lat: 53.349023, lng: -6.248112 }}
  >
    {props.isMarkerShown &&
    <Marker
      position={{ lat: 53.349023, lng: -6.248112 }}
      onClick={props.onMarkerClick}
    />}
  </GoogleMap>
)

export default class Map extends React.PureComponent {
  state = {
    isMarkerShown: true,
  }

  componentDidMount() {
    this.delayedShowMarker()
  }

  delayedShowMarker = () => {
    setTimeout(() => {
      this.setState({ isMarkerShown: true })
    }, 3000)
  }

  handleMarkerClick = () => {
    this.setState({ isMarkerShown: false })
    this.delayedShowMarker()
  }

  render() {
    return (
      <MyMapComponent
        isMarkerShown={this.state.isMarkerShown}
        onMarkerClick={this.handleMarkerClick}
      />
    )
  }
}