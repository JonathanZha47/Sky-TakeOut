package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {

    void create(CategoryDTO categoryDTO);

    PageResult queryPage(CategoryPageQueryDTO categoryPageQueryDTO);

    void startOrStop(int status, long id);

    void edit(CategoryDTO categoryDTO);

    void deleteById(long id);

    List<Category> queryByType(int type);
}
