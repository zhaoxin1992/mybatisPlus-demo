package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.PageQuery;
import com.itheima.mp.domain.vo.InfoVO;
import com.itheima.mp.domain.vo.PageVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<UserVO> queryUserByIds(List<Long> ids) {

        List<User> users = this.baseMapper.queryUserByIds(ids);

        List<UserVO> userVOS = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UserVO userVO = new UserVO();
            userVO.setUsername(user.getUsername());
            userVO.setId(user.getId());
            userVO.setStatus(user.getStatus());
            userVOS.add(userVO);
        }
//        List<UserVO> userVOS = BeanUtil.copyToList(users, UserVO.class);
        return userVOS;
    }


    public List<InfoVO> queryUserByInfo(String name, int status){
        List<User> users  = this.baseMapper.queryUserByInfo(name, status);
        List<InfoVO> infoVOs = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            InfoVO infoVO = new InfoVO();
            infoVO.setId(user.getId());
            infoVO.setUsername(user.getUsername());
            infoVO.setStatus(user.getStatus());
            infoVOs.add(infoVO);
        }

       return infoVOs;
    }

    @Override
    public List<User> queryUsers(String username, Integer status, Long min, Long max) {
        return lambdaQuery().like(User::getUsername, username).list();
    }

    @Override
    public PageVO<UserVO> queryUserByPage(PageQuery query) {
        // 1.分页条件
        Page<User> p = query.toMpPageDefaultSortByUpdate();
        // 2.查询
        page(p);
        // 3.返回
        return new PageVO<>(p, user -> {
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            String username = vo.getUsername();
            vo.setUsername(username.substring(0, username.length()- 4) + "****");
            return vo;
        });
    }
}
