package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category (type, name, sort, create_time, update_time, create_user, update_user, status) " +
            "values (#{type}, #{name}, #{sort},  #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status})")
    void create(Category category);

    Page<Category> queryPage(CategoryPageQueryDTO categoryPageQueryDTO);

    void update(Category category);

    @Delete("delete from category where id = #{id}")
    void delete(long id);

    List<Category> queryByType(int type);
}
