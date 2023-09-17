package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.PageQuery;
import com.itheima.mp.domain.vo.InfoVO;
import com.itheima.mp.domain.vo.PageVO;
import com.itheima.mp.domain.vo.UserVO;

import java.util.List;

/**
 * @author daisy
 */
public interface IUserService extends IService<User> {
    List<UserVO> queryUserByIds(List<Long> ids);

    List<User> queryUsers(String username, Integer status, Long min, Long max);

    List<InfoVO> queryUserByInfo(String name, int status);


    PageVO<UserVO> queryUserByPage(PageQuery query);
}
