package org.ubt.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails {
    private String to;
    private String from;
    private String subject;
    private String text;
    private String attachment;
}
