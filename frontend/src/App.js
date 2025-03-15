import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import CouponClaim from './components/CouponClaim';
import AdminPanel from './components/AdminPannel';

import CouponClaim from './components/CouponClaim';



function App() {
  return (
      <Router>
        <Routes>
          <Route path="/" element={<CouponClaim />} />
          <Route path="/admin" element={<AdminPanel />} />
        </Routes>
      </Router>
  );
}

export default App;