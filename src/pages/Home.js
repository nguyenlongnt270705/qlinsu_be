import React from 'react';
import '../css/Home.css'; // Import CSS file for styling


const Home = () => {
  return (
    
  <div className="page-container">      
    <h1><strong>Xin chào !</strong></h1>
    <div style={{ display: 'flex', justifyContent: 'space-evenly', padding: '10px' }}>
      <div className='card-btn'> 
        <p>Nộp đơn xin nghỉ</p>
      </div>
      <div className='card-btn'>
        <p>Nộp đơn xin nghỉ</p>
      </div>
      <div className='card-btn'>
        <p>Nộp đơn xin nghỉ</p>
      </div>
      <div className='card-btn'>
        <p>Nộp đơn xin nghỉ</p>
      </div>
    </div>
    <div style={{ display:'flex',flexWrap:'warp'}}>
      <div className="box">
        <p>Lịch nghỉ phép</p>
      </div>
      <div >
        <div className="card-btn">
          <p>Lịch nghỉ phép</p>
        </div>
        <div className="card-btn">
          <p>Lịch nghỉ phép</p>
        </div>
      </div>
    </div>
  </div>

  );
};

export default Home;