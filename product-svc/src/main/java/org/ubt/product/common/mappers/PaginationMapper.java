package org.ubt.product.common.mappers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.ubt.product.common.dto.PaginatedResponse;
import org.ubt.product.common.dto.PaginationRequest;
import org.ubt.product.model.Product;

@Component
public class PaginationMapper {

    public PageRequest toPageRequest(PaginationRequest paginationRequest){
        return PageRequest.of(paginationRequest.getPage() - 1 , paginationRequest.getPageSize());
    }

    public PaginatedResponse<Product> toPaginatedResponse(Page page){
        PaginatedResponse paginatedResponse = getPaginatedReponse(page);
        paginatedResponse.setData(page.getContent());
        return paginatedResponse;
    }

    public PaginatedResponse getPaginatedReponse(Page page){
        PaginatedResponse paginatedResponse = new PaginatedResponse<>(page.getContent());
        paginatedResponse.setPage(page.getNumber() + 1);
        paginatedResponse.setTotalPages(page.getTotalPages());
        paginatedResponse.setPageSize(page.getSize());
        paginatedResponse.setTotalItems(page.getTotalPages());

        return paginatedResponse;
    }
}
