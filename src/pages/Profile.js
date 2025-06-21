import React from 'react';
import './Page.css';
import { FaUser } from "react-icons/fa";

const Profile = () => {
  return (
    <div className="page-container">
      <div className="page-header">
        <h2 style={{}}><FaUser style={{ fontSize :'100px'}} />  Hồ sơ cá nhân  </h2>
        <button className="btn btn-primary">Chỉnh sửa</button>
      </div>
      <div className="card">
        <div className="profile-details">
          <p><strong>Họ và tên:</strong> Nguyễn Văn A</p>
          <p><strong>Chức vụ:</strong> Nhân viên</p>
          <p><strong>Email:</strong> nguyenvana@example.com</p>
          <p><strong>Điện thoại:</strong> 0123.456.789</p>
        </div>
      </div>
    </div>
  );
};

export default Profile;