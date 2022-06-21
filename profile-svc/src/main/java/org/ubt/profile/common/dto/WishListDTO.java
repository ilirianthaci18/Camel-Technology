package org.ubt.profile.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishListDTO {
    private int id;

    private String details;

    private double valueOfWishList;

    private UserDTOWishList user;

    @JsonManagedReference
    public UserDTOWishList getUser() {
        return user;
    }
}
