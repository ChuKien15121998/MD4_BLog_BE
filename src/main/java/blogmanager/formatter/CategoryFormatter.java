package blogmanager.formatter;

import blogmanager.service.category.ICategoryService;
import blogmanager.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryFormatter implements Formatter<Category> {

    private ICategoryService categoryService;

    @Autowired
    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> categoryOptional = categoryService.findById(Long.valueOf(text));
        return categoryOptional.orElse(null); // tra ve gia tri cua doi tuong Optional neu co,
        // neu khong thi se tra ve doi tuong null ma ban da truyen vao phuong thuc nay
    }
    // parse chuyen 1 String sang kieu du lieu dich su dung mot Locale xac dinh
    // print chuyen tu mot doi tuong cua kieu du lieu dich sang String

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
