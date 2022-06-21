package org.ubt.profile.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
    private int id;

    private Date created;

    private int quantity;

    private Date dateAdded;

    private UserDTOShoppingCart user;

    @JsonManagedReference
    public UserDTOShoppingCart getUser() {
        return user;
    }
}
