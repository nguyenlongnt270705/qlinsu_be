import React from 'react';
import './Page.css';

const PasswordReset = () => {
  return (
    <div className="auth-container">
      <div className="auth-form">
        <h2>Khôi Phục Mật Khẩu</h2>
        <form>
          <div className="form-group">
            <input type="password" placeholder="Mật khẩu mới" required />
          </div>
          <div className="form-group">
            <input type="password" placeholder="Xác nhận mật khẩu" required />
          </div>
          <button type="submit" className="btn btn-primary" style={{ width: '100%' }}>XÁC NHẬN</button>
        </form>
      </div>
    </div>
  );
};

export default PasswordReset;