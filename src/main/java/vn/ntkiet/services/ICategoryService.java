package vn.ntkiet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.ntkiet.entity.Category;

public interface ICategoryService {

	void deleteById(Integer id);

	long count();

	Optional<Category> findById(Integer id);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll(Sort sort);

	<S extends Category> S save(S entity);
	
	List<Category> findByNameContaining(String name);
	
	Page<Category> findByNameContaining(String name, Pageable pageable);
	
	void delete(Category entity);
	
	void deleteAll();

}
