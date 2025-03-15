import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AdminPannel = () => {
    const [coupons, setCoupons] = useState([]);

    useEffect(() => {
        fetchCoupons();
    }, []);

    const fetchCoupons = async () => {
        const response = await axios.get('/api/coupons');
        setCoupons(response.data);
    };

    return (
        <div>
            <h1>Admin Panel</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Code</th>
                    <th>Claimed</th>
                    <th>Claimed By IP</th>
                    <th>Claimed By Session</th>
                </tr>
                </thead>
                <tbody>
                {coupons.map(coupon => (
                    <tr key={coupon.id}>
                        <td>{coupon.id}</td>
                        <td>{coupon.code}</td>
                        <td>{coupon.claimed ? 'Yes' : 'No'}</td>
                        <td>{coupon.claimedByIp}</td>
                        <td>{coupon.claimedBySession}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default AdminPannel;