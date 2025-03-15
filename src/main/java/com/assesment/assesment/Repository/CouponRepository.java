package com.assesment.assesment.Repository;

import com.assesment.assesment.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByClaimedFalse();
    Coupon findByClaimedByIpOrClaimedBySession(String ip, String session);
}
