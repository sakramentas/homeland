import React from 'react';
import ChatBot from 'react-simple-chatbot';
import { withRouter } from 'react-router';
import { ThemeProvider } from 'styled-components';

import BloodyInterstitial from '../BloodyInterstitial';
import chatbotData from '../../core/chatbot/data';
import './chatbot.css';

// all available props
const theme = {
  background: '#f5f8fb',
  fontFamily: 'Helvetica Neue',
  headerBgColor: '#092f63',
  headerFontColor: '#fff',
  headerFontSize: '15px',
  botBubbleColor: '#092f63',
  botFontColor: '#fff',
  userBubbleColor: '#fff',
  userFontColor: '#4a4a4a'
};

const style = {
  borderRadius: '0px'
};

class Chatbot extends React.PureComponent {
  state = {
    showInterstitial: false,
    showSplashScreen: false,
  };

  componentWillMount() {
    this.setState({ showSplashScreen: true })
  }

  componentDidMount() {
    setTimeout(() => this.setState({ showSplashScreen: false }), 4000);
  }

  displayInter({ value }) {
    const { history } = this.props;
    setTimeout(() => this.setState({ showInterstitial: true }), 1000);

    setTimeout(() => history.push('/maps'), 4000);
  }

  render() {
    return [
      <ThemeProvider theme={theme} key="1">
        {this.state.showSplashScreen ?
          <div className="splash">
            <img src={require('../../assets/splash.png')} alt=""/>
          </div>
          :
          <ChatBot
            headerTitle="Let us find the best home for you"
            recognitionEnable={true}
            steps={chatbotData}
            hideUserAvatar
            className="chatbot"
            style={style}
            hideHeader
            hideBotAvatar
            handleEnd={this.displayInter.bind(this)}
          />
        }
      </ThemeProvider>,
      <BloodyInterstitial show={this.state.showInterstitial} key="2"/>
    ];
  }
}

export default withRouter(Chatbot);
