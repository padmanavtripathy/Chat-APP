import { createContext, useContext, useState } from "react";

const ChatContext = createContext();

export const ChatProvider = ({ children }) => {
  const [roomId, setRoomId] = useState("");
  const [currentUser, setCurrentUser] = useState("");
  const [profilePicture, setProfilePicture] = useState("");
  const [currentStatus, setCurrentStatus]=useState("Offline");
  const [userId, setUserId] = useState("");
  const [connected, setConnected] = useState(false);

  return (
    <ChatContext.Provider
      value={{
        roomId,
        currentUser,
        connected,
        profilePicture,
        currentStatus,
        userId,
        setRoomId,
        setCurrentUser,
        setConnected,
        setProfilePicture,
        setCurrentStatus,
        setUserId,
      }}
    >
      {children}
    </ChatContext.Provider>
  );
};

const useChatContext = () => useContext(ChatContext);
export default useChatContext;