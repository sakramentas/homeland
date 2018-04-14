import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import './styles.scss';
import Chatbot from '../../components/Chatbot';

class ChatbotPage extends Component {
  render() {
    return (
      <div className="transition-item chatbot-page">
        <Chatbot/>
        <Link to={`/maps`} className="list-item">
          <span>maps</span>
        </Link>
      </div>
    );
  }
}

export default ChatbotPage;
