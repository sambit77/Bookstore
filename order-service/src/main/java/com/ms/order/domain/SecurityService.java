package com.ms.order.domain;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public String getLoginUserName() {
        return "user";
    }
}