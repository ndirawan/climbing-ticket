package com.enigma.mountains.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "trx_ticket")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "climber_id")
    @JsonIgnoreProperties("tickets")
    private Climber climber;
    @ManyToOne
    @JoinColumn(name = "mountain_id")
    @JsonIgnoreProperties("tickets")
    private Mountain mountain;
    private Integer quantity;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
