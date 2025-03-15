import React, { useState } from 'react';
import axios from 'axios';

const CouponClaim = () => {
    const [coupon, setCoupon] = useState(null);
    const [message, setMessage] = useState('');

    const claimCoupon = async () => {
        try {
            const response = await axios.get('http://localhost:8080/api/coupons/claim');
            console.log(response);
            setCoupon(response.data);
            setMessage('Coupon claimed successfully!');
        } catch (error) {
            setMessage('Failed to claim coupon. Please try again later.');
        }
    };

    return (
        <div>
            <h1>Claim Your Coupon</h1>
            <button onClick={claimCoupon}>Claim Coupon</button>
            {coupon && <p>Your Coupon Code: {coupon.code}</p>}
            {message && <p>{message}</p>}
        </div>
    );
};

export default CouponClaim;