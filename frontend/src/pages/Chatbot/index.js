import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import './styles.scss';
import Chatbot from '../../components/Chatbot';

class ChatbotPage extends Component {
  render() {
    return (
      <div className="transition-item chatbot-page">
        <Link to={`/maps`} className="list-item">
          <span>maps</span>
        </Link>
        <Chatbot/>
      </div>
    );
  }
}

export default ChatbotPage;
