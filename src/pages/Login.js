import React from 'react';
import './Page.css';

const Login = () => {
  return (
    <div className="auth-container">
      <div className="auth-form card ">
        <h2>Đăng Nhập</h2>
        <form>
          <div className="form-group">
            <input type="text" placeholder="Tên đăng nhập" required />
          </div>
          <div className="form-group">
            <input type="password" placeholder="Mật khẩu" required />
          </div>
          <button type="submit" className="btn btn-primary" style={{ width: '100%' }}>ĐĂNG NHẬP</button>
        </form>
      </div>
    </div>
  );
};

export default Login;