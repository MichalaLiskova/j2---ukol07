package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PostService {
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findPostByOrderByPublishedDesc(pageable);
    }

    public Post getSinglePost(String slug) {
        return postRepository.findBySlug(slug).orElse(null);
    }
}
