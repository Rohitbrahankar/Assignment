package com.assesment.assesment.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

    private String code;
    private boolean claimed;
    private String claimedByIp;
    private String claimedBySession;
}