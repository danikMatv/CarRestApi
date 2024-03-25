package com.foxmided.carrestapi.Service;

import com.foxmided.carrestapi.Model.Category;
import com.foxmided.carrestapi.Repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    public Category getByCategoryId(@Param("categoryId") Integer categoryId) {
        logger.info("getByCategoryId category medot");
        return categoryRepository.getByCategoryId(categoryId);

    }

    public List<Category> getAll() {
        logger.info("getAll category medot");
        return categoryRepository.getAll();
    }
    @Transactional
    public void save(Category entity){
        logger.info("Save category medot");
        categoryRepository.save(entity);
    }
    @Transactional
    public void delete(Integer entityId){
        logger.info("deleteById category medot");
        categoryRepository.deleteById(entityId);
    }

}
