package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
public class RedirectController {

    @Autowired
    private LinkRepository repository;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class LinkNotFoundException extends RuntimeException { }

    @GetMapping("/x/{path}")
    void redirect(@PathVariable String path, HttpServletResponse response) throws IOException {

        Optional<Link> linkOptional = this.repository.findById(path);

        if (linkOptional.isPresent()) {
            response.sendRedirect(linkOptional.get().getRedirectUrl());
        } else {
            throw new LinkNotFoundException();
        }
    }
}

