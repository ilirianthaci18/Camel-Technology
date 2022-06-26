package org.ubt.profile.common.dto;

import org.ubt.profile.common.enums.AccountState;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOWishList {
    private String name;

    private String surname;

    private String address;

    private String phoneNumber;

    private String email;

    private String role;

    private AccountState accountState;

    private boolean deleted;
}
