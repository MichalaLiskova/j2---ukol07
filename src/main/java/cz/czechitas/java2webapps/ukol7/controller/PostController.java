package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Controller
public class PostController {


    private final PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;

    }

    @GetMapping("/")
    public ModelAndView seznamPostu() {
        Sort sort = Sort.by(Sort.Direction.DESC, "published");
        Pageable pageable = PageRequest.of(0, 20, sort); //testovala jsem na 2 a zobrazily se jen 2
        return new ModelAndView("posts")
                .addObject("posts", postService.getAllPosts(pageable));
    }

    @GetMapping("/{slug:.+}")
    public ModelAndView detail(@PathVariable String slug) {
        Post post = postService.getSinglePost(slug);
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("detail")
                .addObject("post", post);
    }
}
