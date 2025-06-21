import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Layout from './components/Layout';
import Login from './pages/Login';
import PasswordReset from './pages/PasswordReset';
import Profile from './pages/Profile';
import Timesheet from './pages/Timesheet';
import Payslip from './pages/Payslip';
import LeaveHistory from './pages/LeaveRequest/LeaveHistory';
import LeaveForm from './pages/LeaveRequest/LeaveForm';
import Notifications from './pages/Notifications';
import Home from './pages/Home';
import './App.css';

function App() {
  // Giả sử người dùng đã đăng nhập để hiển thị layout chính
  const isAuthenticated = true; 

  return (
    <Router>
      <Routes>
        {/* Route cho trang không yêu cầu layout */}
        <Route path="/login" element={<Login />} />
        <Route path="/reset-password" element={<PasswordReset />} />
        
        {/* Route cho các trang yêu cầu layout chính */}
        {isAuthenticated ? (
          <Route path="/" element={<Layout />}>
            <Route index element={<Navigate to="/login" />} />
            <Route path="profile" element={<Profile />} />
            <Route path="timesheet" element={<Timesheet />} />
            <Route path="payslip" element={<Payslip />} />
            <Route path="leave" element={<LeaveHistory />} />
            <Route path="leave/new" element={<LeaveForm />} />
            <Route path="notifications" element={<Notifications />} />
            <Route path="home" element={<Home />} />
          </Route>
        ) : (
          <Route path="*" element={<Navigate to="/login" />} />
        )}
      </Routes>
    </Router>
  );
}

export default App;