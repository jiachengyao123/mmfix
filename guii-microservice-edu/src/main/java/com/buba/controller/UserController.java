package com.buba.controller;


import com.buba.pojo.User;
import com.buba.service.UserService;
import com.guli.common.ov.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MrJia
 * @since 2020-05-09
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询",httpMethod = "GET")
    @GetMapping()
    public R get(){

        List<User> list = userService.list(null);

       return R.ok().data("items",list);
    }

    @PutMapping()
    public R put(@RequestBody User user){
        userService.updateById(user);
        return R.ok().message("修改成功");
    }
    @ApiOperation(value = "删除",httpMethod = "DELETE")
    @DeleteMapping("/del")
    public R del(@RequestBody String[] id){
       userService.removeByIds(Arrays.asList(id));
        return R.ok().message("删除成功");
    }
}

