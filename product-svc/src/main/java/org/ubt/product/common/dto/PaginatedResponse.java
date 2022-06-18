package org.ubt.product.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<T>{

    public PaginatedResponse(List<T> data) {
        this.data=data;
    }

    private List<T> data;
    private int page;
    private int pageSize;
    private int totalPages;
    private int totalItems;
}
