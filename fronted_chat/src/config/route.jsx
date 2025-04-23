import React from 'react'
import { Route,Routes } from 'react-router';
import App from '../App';
import Chat from '../pages/Chat';
import {ChatProvider} from '../context/ChatContext';


const AppRoutes = () => {
  return (
    <ChatProvider>
    <Routes>
        <Route path="/" element={<App />}/>
        <Route path="/chat" element={<Chat /> } />
        <Route path="*" element={<h1>404 Page Not Found</h1> }/>
      </Routes>
      </ChatProvider>
  );
};

export default AppRoutes;