import React, { useState } from 'react'
import { Pencil, Filter, Search, CloudSnow } from 'lucide-react'
import useChatContext from "../context/ChatContext";

const initialChats = Array.from({ length: 20 }, (_, i) => ({
  id: i + 1,
  name: `Contact ${i + 1}`,
  message: i % 2 === 0 ? 'Hey! Let’s connect.' : 'Missed call',
  time: '15:3' + (i % 10),
  unread: i % 3 === 0 ? i : 0,
  avatar: `https://randomuser.me/api/portraits/men/${i + 10}.jpg`
}))

const ChatList = () => {
  const [search, setSearch] = useState('')
  const [chats] = useState(initialChats)

  const filteredChats = chats.filter(chat =>
    chat.name.toLowerCase().includes(search.toLowerCase())
  )

  const { setCurrentUser,setProfilePicture } = useChatContext();
  function setData(name,profilePicture){
    setCurrentUser(name);
    setProfilePicture(profilePicture)
    console.log('first', profilePicture.message);
    
  }

  return (
    <div className="flex flex-col h-full bg-white">
      {/* Header */}
      <div className="flex items-center justify-between px-4 py-3 border-b text-lg font-semibold">
        <span class="text-blue-950">Chats</span>
        <div className="flex gap-4">
          <Pencil className="w-5 h-5 text-gray-600 cursor-pointer" />
          <Filter className="w-5 h-5 text-gray-600 cursor-pointer" />
        </div>
      </div>

      {/* Search Bar */}
      <div className="px-4 py-2 border-b">
        <div className="relative">
          <input
            type="text"
            placeholder="Search or start new chat"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="w-full px-10 py-2 text-sm border rounded-full focus:outline-none focus:ring-2 focus:ring-blue-500 bg-gray-100 text-blue-950"
          />
          <Search className="absolute left-3 top-2.5 w-4 h-4 text-gray-400" />
        </div>
      </div>

      {/* Scrollable Chat List */}
      <div className="flex-1 overflow-y-auto">
        {filteredChats.length > 0 ? (
          filteredChats.map((chat) => (
            <div
              key={chat.id}
              className="flex items-center gap-3 px-4 py-3 hover:bg-gray-100 cursor-pointer border-b"
            >
              <img
                src={chat.avatar}
                alt={chat.name}
                className="w-12 h-12 rounded-full object-cover"
              />
              <button onClick={() => setData(chat.name,chat.avatar)}>
              <div className="flex justify-between items-center w-full">
                <div className="flex flex-col truncate">
                  <span className="font-medium truncate text-black">{chat.name}</span>
                  <span className="text-sm text-gray-500 truncate">{chat.message}</span>
                </div>
                <div className="flex flex-col items-end">
                  <span className="text-xs text-blue-600">{chat.time}</span>
                  {chat.unread > 0 && (
                    <span className="text-xs bg-blue-500 text-white px-2 py-0.5 rounded-full mt-1">
                      {chat.unread}
                    </span>
                  )}
                </div>
              </div>
              </button>
            </div>
          ))
        ) : (
          <div className="text-center text-gray-400 py-8">No chats found</div>
        )}
      </div>
    </div>
  )
}

export default ChatList