package org.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    @Id
    private String path;

    @NotNull
    private String redirectUrl;

    @NotNull
    private String url;

    public Link(String path, @NotNull String redirectUrl) {
        this.path = path;
        this.redirectUrl = redirectUrl;
        this.url = "http://localhost:8080/x/" + path;
    }

}
