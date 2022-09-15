package org.ubt.chat.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Coversation {

    @Id
    @SequenceGenerator(name = "conversation_sequence", sequenceName = "conversation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conversation_sequence")
    @Column
    private long id;

    @Column
    private String title;

    @Column
    private LocalDateTime dateCreated;

    @Column
    private boolean available;

    @Column
    private String type;

    @Column
    private Time chatTime;


}
