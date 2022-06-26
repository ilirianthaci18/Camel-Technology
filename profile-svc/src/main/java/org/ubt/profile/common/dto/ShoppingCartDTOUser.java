package org.ubt.profile.common.dto;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTOUser {
    private Date created;

    private int quantity;

    private Date dateAdded;
}
