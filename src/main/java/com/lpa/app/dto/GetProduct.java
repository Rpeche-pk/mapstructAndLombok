package com.lpa.app.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProduct {
    private Long productId;
    private String productName;
    private String creationDate;
    private GetCategory category;
    private String price;
}
