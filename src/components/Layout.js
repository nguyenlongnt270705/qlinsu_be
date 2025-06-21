import React from 'react';
import { NavLink, Outlet } from 'react-router-dom';
import './Layout.css';
import { FaHome , FaUserCircle} from 'react-icons/fa'; 
import { IoIosNotificationsOutline } from 'react-icons/io';

const Layout = () => {
  return (
    <div className="app-layout">
      <header className="app-header">
        <div className="logo"><FaHome style={{fontSize:'20px'}} /> <NavLink to="/home" style={{color:'black'}}>Trang chủ</NavLink> </div>
        <nav className="app-nav">
          <NavLink to="/timesheet">Chấm công</NavLink>
          <NavLink to="/payslip">Phiếu lương</NavLink>
          <NavLink to="/leave">Nghỉ phép</NavLink>
        </nav>
        <div className="user-profile">
          <NavLink to="/notifications"><IoIosNotificationsOutline style={{color:'black',fontSize:' 40px'}} /></NavLink>
          <NavLink to="/profile"> <FaUserCircle style={{color:'skyblue',fontSize:'50px'}} /></NavLink>
        </div>
      </header>
      <main className="app-content">
        <Outlet /> {/* Đây là nơi nội dung của các trang con sẽ được hiển thị */}
      </main>
    </div>
  );
};

export default Layout;