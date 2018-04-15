import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './styles.scss';
import Chatbot from '../../components/Chatbot';

class ChatbotPage extends Component {
  render() {
    return (
      <div className="transition-item chatbot-page">
        <Chatbot />
      </div>
    );
  }
}

export default ChatbotPage;
