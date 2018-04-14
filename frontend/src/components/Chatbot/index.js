import React from 'react';
import ChatBot from 'react-simple-chatbot';
import { ThemeProvider } from 'styled-components';
import chatbotData from '../../core/chatbot/data';
import './styles.scss';

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
  userFontColor: '#4a4a4a',
};

const style = {
  height: 'calc(100vh - 55px)',
  borderRadius: '0px',
  position: 'relative'
};

const contentStyle = {
  height: 'auto'
};

const footerStyle = {
  position: 'absolute',
  bottom: 0,
  width: '100%'
};

export default class Chatbot extends React.PureComponent {
  render() {
    return (
      <ThemeProvider theme={theme}>
        <ChatBot
          headerTitle="Let us find the best home for you"
          recognitionEnable={true}
          steps={chatbotData}
          hideUserAvatar
          className="chatbot"
          style={style}
          footerStyle={footerStyle}
          contentStyle={contentStyle}
          hideHeader
        />
      </ThemeProvider>
    )
  }
}