import React from 'react';
import '../css/Payslip.css'; 

const Payslip = () => {
  return (
    <div className="page-container">
          
          <div className="card">
            <div style={{ display: 'flex', justifyContent: 'space-between', padding: '10px' }}>
              <div className='card-payslip'>
                <p>Số ngày đã nghỉ</p>
              </div>
              <div className='card-payslip'>
                <p>Số ngày còn lại</p>
              </div>
            </div>
            <table className="payslip-table">
              <thead>
                <tr>
                  <th>Bắt đầu</th>
                  <th>Kết thúc</th>
                  <th>Lý do</th>
                  <th>Trạng thái</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>01/01/2025</td>
                  <td>02/04/2025</td>
                  <td>Du lịch</td>
                  <td>Đã duyệt</td>
                </tr>
                <tr>
                  <td>05/01/2025</td>
                  <td>07/01/2025</td>
                  <td>Ốm đau</td>
                  <td>Chưa duyệt</td>
                </tr>
                <tr>
                  <td>10/01/2025</td>
                  <td>12/01/2025</td>
                  <td>Công việc gia đình</td>
                  <td>Từ chối</td>
                </tr>
                </tbody>
            </table>
          </div>
        </div>
  );
};

export default Payslip;