package blogmanager.repository;

import blogmanager.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategotyRepository extends PagingAndSortingRepository<Category, Long> {

}
