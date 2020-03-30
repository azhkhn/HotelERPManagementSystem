package com.demo.hotel.business.service;

import com.demo.hotel.provider.api.AdminService;
import com.demo.hotel.provider.domain.Admin;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义认证授权
 * <p>
 * Description:
 * </p>
 *
 * @author syj
 * @see com.demo.hotel.business.service
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private AdminService adminService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //查询用户
        Admin admin = adminService.get(s);

        // 默认所有用户拥有 USER 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);

        // 用户存在
        if (admin != null) {
            return new User(admin.getUsername(), admin.getPassword(), grantedAuthorities);
        }

        // 用户不存在
        else {
            return null;
        }


    }
}