package org.ubt.profile.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricalOrderDTO {
    private int id;

    private String details;

    private String orderType;

    private UserDTOHistoricalOrder user;

    @JsonManagedReference
    public UserDTOHistoricalOrder getUser() {
        return user;
    }
}
