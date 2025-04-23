import React from 'react'
import NavBar from '../components/NavBar'
import ChatHeader from '../components/ChatHeader'
import Message from '../components/message'
import ChatBar from '../components/ChatBar'
import ChatList from '../components/ChatList'
import Sidebar from '../components/SideBar'

const Chat = () => {
  return (
    <div className="flex flex-col h-screen overflow-hidden">
      {/* Top Navbar */}
      <div className="h-16 flex-shrink-0">
        <NavBar />
      </div>

      {/* Main content row */}
      <div className="flex flex-1 overflow-hidden">
        {/* Sidebar (hidden on mobile) */}
        <div className="hidden md:flex basis-2/6 h-full overflow-hidden">
          {/* Sidebar */}
          <div className="w-16 bg-[#111B21] flex-shrink-0">
            <Sidebar />
          </div>

          {/* Chat List */}
          <div className="flex-1 bg-white overflow-y-auto">
            <ChatList />
          </div>
        </div>

        {/* Chat area */}
        <div className="flex flex-col flex-1">
          <div className="h-16 flex-shrink-0">
            <ChatHeader />
          </div>

          {/* Scrollable message area */}
          <div className="flex-1 overflow-y-auto">
            <Message />
          </div>

          {/* Chat input bar */}
          <div className="h-20 flex-shrink-0">
            <ChatBar />
          </div>
        </div>
      </div>
    </div>
  )
}

export default Chat