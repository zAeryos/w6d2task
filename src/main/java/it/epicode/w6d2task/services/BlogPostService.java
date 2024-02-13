package it.epicode.w6d2task.services;

import it.epicode.w6d2task.models.Author;
import it.epicode.w6d2task.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BlogPostService {

    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    public BlogPost getBlogPostById(int id) throws NoSuchElementException{
        Optional<BlogPost> bp = blogPosts.stream().filter(blogPost -> blogPost.getId() == id).findAny();
        if (bp.isPresent()) {
            return bp.get();
        } else {
            throw new NoSuchElementException("Blog Post not found");
        }
    }

    public void saveBlogPost(BlogPost blogPost) {
        blogPosts.add(blogPost);
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPost) throws NoSuchElementException {
        BlogPost bp = getBlogPostById(id);

        bp.setTitle(blogPost.getTitle());
        bp.setCategory(blogPost.getCategory());
        bp.setContent(blogPost.getContent());
        bp.setCover(blogPost.getCover());
        bp.setReadTime(blogPost.getReadTime());

        return bp;
    }

    public void deleteBlogPost(int id) throws NoSuchElementException {
        BlogPost bp = getBlogPostById(id);

        blogPosts.remove(bp);
    }

}
