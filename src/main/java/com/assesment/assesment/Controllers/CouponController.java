package com.assesment.assesment.Controllers;

import com.assesment.assesment.Model.Coupon;
import com.assesment.assesment.Services.CouponServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponServices couponService;

    @GetMapping("/claim")
    public Coupon claimCoupon(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String session = request.getSession().getId();
        return couponService.getNextCoupon(ip, session);
    }
}