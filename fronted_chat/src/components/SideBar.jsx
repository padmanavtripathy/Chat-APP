import React from "react";
import {
  MessageCircle,
  Users,
  Clock,
  Star,
  LogOut,
  Settings,
  Square,
  NotebookPen
} from "lucide-react";

const Sidebar = () => {
  return (
    <div className="bg-[#111B21] w-14 flex flex-col items-center py-4 gap-6 text-white h-full">
      {/* WhatsApp icon with badge */}
      <div className="relative">
        <div className="w-8 h-8 rounded-full bg-blue-500 flex items-center justify-center text-xs">
          B
        </div>
        <div className="absolute -top-1 -right-1 w-4 h-4 bg-blue-600 rounded-full text-xs flex items-center justify-center">
          9
        </div>
      </div>

      {/* Menu icons */}
      <div className="flex flex-col gap-6 text-gray-400">
        <Users className="w-5 h-5 hover:text-white cursor-pointer" />
        <MessageCircle className="w-5 h-5 hover:text-white cursor-pointer" />
        <Clock className="w-5 h-5 hover:text-white cursor-pointer" />
        <NotebookPen className="w-5 h-5 hover:text-white cursor-pointer" />
        <Star className="w-5 h-5 hover:text-white cursor-pointer" />
        <Settings className="w-5 h-5 hover:text-white cursor-pointer" />
        <LogOut className="w-5 h-5 hover:text-white cursor-pointer" />
      </div>
    </div>
  );
};

export default Sidebar;
