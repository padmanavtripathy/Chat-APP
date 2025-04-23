import { useState } from 'react'
import './App.css'
import toast from 'react-hot-toast'
import JoinCreateChatComponent from './components/joinCreateChat';

function App() {
  const [count, setCount] = useState(0)
  const notify = () => toast('Here is your toast.');

  return (
    <div>
      <JoinCreateChatComponent />
    </div>
  );
}

export default App