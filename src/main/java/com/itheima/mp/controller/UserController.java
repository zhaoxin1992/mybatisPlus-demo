package com.itheima.mp.controller;

import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.PageQuery;
import com.itheima.mp.domain.vo.InfoVO;
import com.itheima.mp.domain.vo.PageVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author daisy
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/page")
    public PageVO<UserVO> queryUserByPage(PageQuery query){
        return userService.queryUserByPage(query);
    }

    @GetMapping("/getByids")
    public List<UserVO> queryUserByIds(Long id) {
        List<Long> ids = new Vector<>();
        ids.add(id);
        return userService.queryUserByIds(ids);
    }

    @GetMapping("/getByinfo")
    public List<InfoVO> queryUserByInfo(String name, int status){
        return userService.queryUserByInfo(name, status);
    }

}
