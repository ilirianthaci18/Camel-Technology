package org.ubt.chat.model;


import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Message {
    @Id
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    @Column
    private long id;

    @Column
    public String content;

    @Column
    public LocalDateTime timeStamp;

    @Column
    public int userId;

    @Column
    public int conversationId;

    @Column
    public String link;



}
