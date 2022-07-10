package org.ubt.profile.model;

import lombok.*;

import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Search {

    private Long id;

    private String searchEmail;

    private List<String> searchText;
}
