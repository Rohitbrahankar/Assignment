package com.assesment.assesment.Services;
import com.assesment.assesment.Model.Coupon;
import com.assesment.assesment.Repository.CouponRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServices{

    @Autowired
    private CouponRepository couponRepository;

    public Coupon getNextCoupon(String ip, String session) {
        List<Coupon> availableCoupons = couponRepository.findByClaimedFalse();
        if (!availableCoupons.isEmpty()) {
            Coupon coupon = availableCoupons.get(0);
            coupon.setClaimed(true);
            coupon.setClaimedByIp(ip);
            coupon.setClaimedBySession(session);

           return couponRepository.saveAndFlush(coupon);
        }
        return null;
    }


}