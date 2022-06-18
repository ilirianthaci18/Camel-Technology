package org.ubt.product.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class PaginationRequest {

    @NotNull
    @Positive
    private int page=1;

    @NotNull
    @Positive
    private int pageSize=20;
}
