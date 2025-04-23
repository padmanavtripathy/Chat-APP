import React, { useEffect, useRef } from 'react'

const messages = [
  { id: 1, text: "Hey, how are you?", from: "other" },
  { id: 2, text: "I’m good, you?", from: "me" },
  { id: 3, text: "All well, thanks!", from: "other" },
  { id: 4, text: "Let’s catch up soon.", from: "me" },
  { id: 5, text: "More messages coming...", from: "other" },
  { id: 6, text: "Even more to test scrolling...", from: "me" },
  { id: 7, text: "Keep scrolling 😄", from: "other" },
  { id: 8, text: "Let’s catch up soon.", from: "me" },
  { id: 9, text: "More messages coming...", from: "other" },
  { id: 10, text: "Even more to test scrolling...", from: "me" },
  { id: 11, text: "Keep scrolling 😄", from: "other" },
  { id: 12, text: "Let’s catch up soon.", from: "me" },
  { id: 13, text: "More messages coming...", from: "other" },
  { id: 14, text: "Even more to test scrolling...", from: "me" },
  { id: 15, text: "Keep scrolling 😄", from: "other" },
  { id: 16, text: "Keep scrolling 😄", from: "other" },
  { id: 17, text: "Keep scrolling 😄", from: "other" },
  { id: 18, text: "Keep scrolling 😄", from: "other" },
]

const Message = () => {
  const scrollRef = useRef(null)

  useEffect(() => {
    // Scroll to bottom when mounted
    scrollRef.current?.scrollTo({
      top: scrollRef.current.scrollHeight,
      behavior: 'smooth',
    })
  }, [])

  return (
    <div className="h-full flex flex-col bg-white">
      <div
        className="flex-1 overflow-y-auto px-4 py-2 space-y-2"
        ref={scrollRef}
        style={{ scrollbarWidth: 'none' }}
      >
        {messages.map((msg) => (
          <div
            key={msg.id}
            className={`flex ${msg.from === 'me' ? 'justify-end' : 'justify-start'}`}
          >
            <div
              className={`px-4 py-2 rounded-lg text-sm max-w-xs break-words ${
                msg.from === 'me'
                  ? 'bg-blue-500 text-white rounded-br-none'
                  : 'bg-gray-200 text-gray-900 rounded-bl-none'
              }`}
            >
              {msg.text}
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

export default Message