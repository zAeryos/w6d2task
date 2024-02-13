package it.epicode.w6d2task.controllers;

import it.epicode.w6d2task.models.BlogPost;
import it.epicode.w6d2task.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/blog-posts")
    public List<BlogPost> getAuthorList() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/blog-posts/id")
    public BlogPost getBlogPostByIdQueryParams(@RequestParam int id) {
        return blogPostService.getBlogPostById(id);
    }

    @GetMapping("/blog-posts/{id}")
    public BlogPost getBlogPostByIdPathParam(@PathVariable int id) {
        return blogPostService.getBlogPostById(id);
    }

    @PostMapping("/blog-posts")
    public void createBlogPost(@RequestBody BlogPost blogPost) {
        blogPostService.saveBlogPost(blogPost);
    }

    @PutMapping("/blog-posts/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPost blogPost) {
        return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/blog-posts/{id}")
    public void deleteBlogPost(@PathVariable int id) {
        blogPostService.deleteBlogPost(id);
    }

}
