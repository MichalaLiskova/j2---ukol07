package cz.czechitas.java2webapps.ukol7.repository;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import jakarta.persistence.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface    PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.slug = ?1")
    Optional<Post> findBySlug(String slug);



    @Query("select p from Post p order by p.published DESC")
    Page<Post> findPostByOrderByPublishedDesc(Pageable pageable);


}
