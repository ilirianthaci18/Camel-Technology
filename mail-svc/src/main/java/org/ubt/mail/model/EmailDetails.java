package org.ubt.mail.model;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    @NonNull
    private String to;
    private String from;
    @NonNull
    private String subject;
    @NonNull
    private String text;
    private String attachment;
}
