package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping
    @ApiOperation("创建新的分类")
    public Result newCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("新分类创建：{}",categoryDTO);
        categoryService.create(categoryDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> queryPage(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询：{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.queryPage(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/status/{status}")
    @ApiOperation("分类禁用启动")
    public Result toggleOnStopOrStart(@PathVariable int status, long id){
        log.info("菜品:{},禁用/启动:{}",id, status);
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteCategoryById(long id){
        log.info("分类：{},正在被删除",id);
        categoryService.deleteById(id);
        return Result.success();
    }
    @PutMapping
    @ApiOperation("修改菜品分类信息")
    public Result editCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("修改菜品分类:{}",categoryDTO);
        categoryService.edit(categoryDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> queryCategoryByType(int type){
        log.info("当前类型查询:{}",type);
        List<Category> categories = categoryService.queryByType(type);
        return Result.success(categories);
    }
}
