package org.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@RestController
public class RedirectController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private LinkEventRepository linkEventRepository;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class LinkNotFoundException extends RuntimeException { }

    @GetMapping("/x/{path}")
    void redirect(@PathVariable String path, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Optional<Link> linkOptional = this.linkRepository.findById(path);

        if (linkOptional.isPresent()) {
            LinkEvent linkEvent = new LinkEvent(
                    new Date(),
                    linkOptional.get(),
                    request.getHeader("user-agent"),
                    request.getHeader("referrer"),
                    request.getRemoteHost()
            );
            this.linkEventRepository.save(linkEvent);

            response.sendRedirect(linkOptional.get().getRedirectUrl());
        } else {
            throw new LinkNotFoundException();
        }
    }
}

