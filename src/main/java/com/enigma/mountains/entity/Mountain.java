package com.enigma.mountains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_mountain")
@Getter
@Setter
@NoArgsConstructor
public class Mountain {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private Integer height;
    private Integer quota;
    @OneToMany(mappedBy = "mountain")
    @JsonIgnore
    private List<Ticket> tickets;

}
