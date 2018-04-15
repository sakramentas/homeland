import React from 'react';
import ChatBot from 'react-simple-chatbot';
import { ThemeProvider } from 'styled-components';
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
          hideHeader
        />
      </ThemeProvider>
    );
  }
}
