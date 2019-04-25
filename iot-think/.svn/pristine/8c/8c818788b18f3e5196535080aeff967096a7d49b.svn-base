package com.rz.iot.think.shiro;

import com.rz.iot.think.mapper.UserInfoMapper;
import com.rz.iot.think.model.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 进行登录认证以及权限认证的自定义realm
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 权限验证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //得到当前登录对象
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

        //权限集合
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleSet = new HashSet<>();
        permissionSet.add("user:add");
        roleSet.add("admin");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        simpleAuthorizationInfo.setRoles(roleSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 密码加密方式
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //Principal 当事人
        //Credentials 认证信息

        //获取登录用户名
        String username = (String) authenticationToken.getPrincipal();
        //realm名字
        String realmName = super.getName();
        //这里做登陆信息验证。。。

        UserInfo userInfo = userInfoMapper.findByUsername(username);
        if (userInfo==null) {
            //用户名不存在
            throw new UnknownAccountException();
        }
        //盐值
        ByteSource credentialsSalt =  ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(), credentialsSalt, realmName);
        return simpleAuthenticationInfo;
    }
}
