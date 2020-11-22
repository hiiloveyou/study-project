//package com.chenyi.study.webmvc.shiroconfiguration;
//
//import org.apache.shiro.authc.*;
//import org.apache.shiro.realm.Realm;
//
//import java.util.Objects;
//
///**
// * @author chenyi
// * @date 2020/11/12
// */
//public class MyRealm implements Realm {
//
//    @Override
//    public String getName() {
//        return "chenyiRealm";
//    }
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof UsernamePasswordToken;
//    }
//
//    @Override
//    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        final String username = (String) token.getPrincipal();
//        final String password = new String((char[]) token.getCredentials());
//
//        if (!Objects.equals(username, "chenyi")) {
//            throw new UnknownAccountException();
//        }
//
//        if (!Objects.equals(password, "123")) {
//            throw new IncorrectCredentialsException();
//        }
//
//        return new SimpleAuthenticationInfo(username, password, getName());
//    }
//}
