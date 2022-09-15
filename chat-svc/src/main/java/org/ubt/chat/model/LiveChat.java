package org.ubt.chat.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ubt.chat.common.enums.Status;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class LiveChat {

    @Id
    @SequenceGenerator(name="live_chat_sequence",sequenceName = "live_chat_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "live_chat_sequence")
    @Column
    private int id;

    @Column
    private int conversationId;

    @Column
    private int meetingId;

    @Column
    private Status messageStatus;

    @Column
    private int messageStartId;

    @Column
    private int messageEndId;
}
