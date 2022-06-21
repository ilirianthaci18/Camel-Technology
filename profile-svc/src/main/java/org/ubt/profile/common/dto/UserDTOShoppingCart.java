package org.ubt.profile.common.dto;

import lombok.*;
import org.ubt.profile.common.enums.AccountState;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOShoppingCart {
    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private String email;

    private String role;

    private AccountState accountState;

    private boolean deleted;

}
