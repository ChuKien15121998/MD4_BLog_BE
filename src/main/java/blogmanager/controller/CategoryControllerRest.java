package blogmanager.controller;

import blogmanager.model.Blog;
import blogmanager.model.Category;
import blogmanager.service.blog.IBlogService;
import blogmanager.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryControllerRest {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> listCategory() {
        Iterable<Category> categories = categoryService.findAll();
        if (categories != null) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/blogs")
    public ResponseEntity<Iterable<Blog>> findBlogsByCategory(@PathVariable Optional<String> id) {
        Optional<Category> categoryOptional = categoryService.findById(Long.valueOf(id.get()));
        Iterable<Blog> blogs = blogService.findAllByCategory(categoryOptional.get());
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
