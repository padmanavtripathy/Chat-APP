import React from 'react'

const contacts = [
  { id: 0, name: 'Alison Medina (You)', message: 'Message yourself', self: true },
  { id: 1, name: 'Ahmed Gamal', message: '' },
  { id: 2, name: 'Sara', message: '🌹' },
  { id: 3, name: 'David Rosales', message: 'Available. Hit me up!' },
  { id: 4, name: 'Nora Ingram', message: '' },
  { id: 5, name: 'Harrison', message: '' },
]

const WhatsAppContactList = () => {
  return (
    <div className="h-full overflow-y-auto bg-white text-gray-900">
      {/* Top actions */}
      <div className="p-4 space-y-4 border-b">
        <div className="flex items-center gap-3 cursor-pointer hover:bg-gray-100 p-2 rounded">
          <span className="bg-green-600 text-white p-2 rounded-full">👥</span>
          <span>New group</span>
        </div>
        <div className="flex items-center gap-3 cursor-pointer hover:bg-gray-100 p-2 rounded">
          <span className="bg-green-600 text-white p-2 rounded-full">➕</span>
          <span>New contact</span>
          <span className="ml-auto text-gray-500 text-xs">📷</span>
        </div>
        <div className="flex items-center gap-3 cursor-pointer hover:bg-gray-100 p-2 rounded">
          <span className="bg-green-600 text-white p-2 rounded-full">🌐</span>
          <span>New community</span>
        </div>
        <p className="text-xs text-gray-400 mt-2">Contacts on WhatsApp</p>
      </div>

      {/* Contact list */}
      <div className="divide-y">
        {contacts.map((contact) => (
          <div key={contact.id} className="flex items-center gap-3 p-4 hover:bg-gray-100 cursor-pointer">
            <div className="w-10 h-10 rounded-full bg-gray-300 flex items-center justify-center text-sm">
              {/* Placeholder for avatar */}
              {contact.name[0]}
            </div>
            <div className="flex flex-col">
              <span className="font-medium">{contact.name}</span>
              {contact.message && (
                <span className="text-sm text-gray-500">{contact.message}</span>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

export default WhatsAppContactList