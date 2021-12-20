package org.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date date;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    private Link link;

    private String agent;

    private String referrer;

    private String ip;

    public LinkEvent(@NotNull Date date, @NotNull Link link, String agent, String referrer, String ip) {
        this.date = date;
        this.link = link;
        this.agent = agent;
        this.referrer = referrer;
        this.ip = ip;
    }
}
