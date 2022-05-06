package org.ubt.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseTemplateData extends EmailDetails{
    private String greetingsInLocalLanguage;
    private String mainContentDescription;
    private String actionDescription;
    private String recipientFullName;
    private String linkNameInLocalLanguage;
    private String linkAction;
    private String commentNameInLocalLanguage;
    private String commentOnApproval;
}
