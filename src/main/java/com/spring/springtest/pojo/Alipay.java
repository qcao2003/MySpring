package com.spring.springtest.pojo;

import lombok.Data;

@Data
public class Alipay {
    private String traceNo;

    private String totalAmount;

    private String subject;

    private String alipayTraceNo;

    private String product_code;

    private String trade_status;

    private String buyer_id;
}
