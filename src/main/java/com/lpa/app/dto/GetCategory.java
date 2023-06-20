package com.lpa.app.dto;

import com.lpa.app.entity.Category;
import lombok.*;

@Getter
@ToString
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCategory {

    private Long categoryId;
    private String categoryName;

}
