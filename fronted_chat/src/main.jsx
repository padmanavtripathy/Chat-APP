import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BrowserRouter } from "react-router";
import './index.css'
import AppRoutes from './config/route.jsx';
import { Toaster } from 'react-hot-toast';

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
    <Toaster position='top-right'/>
      <AppRoutes />
    </BrowserRouter>
  </StrictMode>,
)
