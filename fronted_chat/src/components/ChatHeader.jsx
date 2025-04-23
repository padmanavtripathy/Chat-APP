import React from 'react'
import { ArrowLeft, Video, Phone, MoreVertical } from 'lucide-react'
import useChatContext from '../context/ChatContext'

const ChatBar = () => {
  var chat=useChatContext();
  return (
    <div className="h-16 bg-blue-600 text-white flex items-center justify-between px-4">
      {/* Left: back button + profile image + name + status */}
      <div className="flex items-center space-x-3">
        <ArrowLeft className="md:hidden w-5 h-5 cursor-pointer" />
        
        {/* Profile picture (temporary placeholder) */}
        <img
          src={chat.profilePicture}
          alt="Profile"
          className="w-10 h-10 rounded-full object-cover"
        />

        {/* Name and status */}
        <div className="leading-tight">
          <div className="font-semibold text-sm">{chat.currentUser}</div>
          <div className="text-xs text-white/80">{chat.currentStatus}</div>
        </div>
      </div>

      {/* Right: action icons */}
      <div className="flex items-center space-x-4">
        <Video className="w-5 h-5 cursor-pointer" />
        <Phone className="w-5 h-5 cursor-pointer" />
        <MoreVertical className="w-5 h-5 cursor-pointer" />
      </div>
    </div>
  )
}

export default ChatBar