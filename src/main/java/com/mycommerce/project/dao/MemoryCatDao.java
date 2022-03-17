package com.mycommerce.project.dao;

import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.exception.UnknownProductException;
import com.mycommerce.project.model.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 public class MemoryCatDao implements CategoryDao {
    private static List<Category> categories = new ArrayList();
    private static Long idSequence = 1L;
    MemoryCatDao() {
    }

    @Override
    public Long add(Category category) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        category.setId(var1);
        categories.add(category);
        return var1;
    }

    @Override
    public void update(Category category) {
        int index = this.getCategoryIndexById(category.getId());
        if (index > -1) {
            categories.set(index, category);
        } else {
            throw new UnknownProductException(category.getId());
        }
    }

    @Override
    public Category findById(Long id) {
        int index = this.getCategoryIndexById(id);
        if (index > -1) {
            Category category = (Category) categories.get(index);
            return category;
        } else {
            throw new UnknownProductException(id);
        }
    }

    @Override
    public List<Category> getAll() {
        return Collections.unmodifiableList(categories);
    }

    @Override
    public void remove(Category category) {
        this.remove(category.getId());
    }

    @Override
    public void remove(Long id) {
        int index = this.getCategoryIndexById(id);
        if (index > -1) {
            categories.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private int getCategoryIndexById(Long id) {
        for (int i = 0; i < categories.size(); ++i) {
            Category category = categories.get(i);
            if (category.getId()==id) {
                return i;
            }
        }
        return -1;
    }
}
