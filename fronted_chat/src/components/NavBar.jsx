import React, { useState } from 'react'
import {
  MessageCircle,
  Users,
  Clock,
  Star,
  LogOut,
  Settings,
  Square,
  NotebookPen,
  Menu
} from 'lucide-react'

const NavBar = () => {
  const [isOpen, setIsOpen] = useState(false)

  const toggleMenu = () => setIsOpen(!isOpen)

  return (
    <nav className="bg-white border-b border-gray-200 dark:bg-gray-900">
      <div className="max-w-screen-xl mx-auto flex items-center justify-between px-4 py-2">
        {/* Logo */}
        <a href="/" className="flex items-center space-x-2">
          <img
            src="https://flowbite.com/docs/images/logo.svg"
            className="h-6 w-6"
            alt="TalkSpace Logo"
          />
          <span className="text-xl font-semibold text-gray-900 dark:text-white">
            TalkSpace
          </span>
        </a>

        {/* Hamburger for mobile only */}
        <div className="md:hidden relative">
          <button
            type="button"
            onClick={toggleMenu}
            className="flex items-center justify-center p-2 w-8 h-8 text-gray-500 hover:bg-gray-100 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
            aria-label="Toggle menu"
          >
            <Menu className="w-5 h-5" />
          </button>

          {isOpen && (
            <div className="absolute right-0 mt-2 w-44 bg-white shadow-lg rounded-md z-50 dark:bg-gray-800 p-2 space-y-1">
              <MenuItem icon={<MessageCircle size={16} />} label="Messages" />
              <MenuItem icon={<Users size={16} />} label="Contacts" />
              <MenuItem icon={<Clock size={16} />} label="Recent" />
              <MenuItem icon={<Star size={16} />} label="Favorites" />
              <MenuItem icon={<NotebookPen size={16} />} label="Notes" />
              <MenuItem icon={<Square size={16} />} label="Projects" />
              <MenuItem icon={<Settings size={16} />} label="Settings" />
              <MenuItem icon={<LogOut size={16} />} label="Logout" />
            </div>
          )}
        </div>
      </div>
    </nav>
  )
}

const MenuItem = ({ icon, label }) => (
  <div className="flex items-center space-x-2 text-sm text-gray-700 dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 rounded-md px-2 py-1 cursor-pointer">
    {icon}
    <span>{label}</span>
  </div>
)

export default NavBar