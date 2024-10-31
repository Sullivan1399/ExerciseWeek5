package vn.ntkiet.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;
import vn.ntkiet.entity.Category;
import vn.ntkiet.repository.ICategoryRepository;
import vn.ntkiet.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	ICategoryRepository categoryRepository;

	public CategoryServiceImpl(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		// TODO Auto-generated constructor stub
	}

	@Override
	public <S extends Category> S save(S entity) {
	    if (entity.getCategoryId() == 0) {
	        return categoryRepository.save(entity);
	    } else {
	        Optional<Category> opt = findById(entity.getCategoryId());
	        if (opt.isPresent()) {
	            if (StringUtils.isEmpty(entity.getCategoryName())) {
	                entity.setCategoryName(opt.get().getCategoryName());
	            } else {
	                entity.setCategoryName(entity.getCategoryName());
	            }
	        }
	    }
	    return categoryRepository.save(entity);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

	public List<Category> findByNameContaining(String name) {
		return categoryRepository.findByNameContaining(name);
	}

	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByNameContaining(name, pageable);
	}

	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	
	
}
