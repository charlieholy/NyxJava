package com.nyx.shiro.realm;

import com.nyx.dao.UserDao;
import com.nyx.vo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.*;

public class CustomRealm extends AuthorizingRealm {

    Map<String,String> userMap = new HashMap<String, String>(16);
    {
        userMap.put("Mark","d40fdd323f5322ff34a41f026f35cf20");
        super.setName("customRealm");
    }

    @Resource
    private UserDao userDao;

    /**
     * 通过username获取密码
     * @param userName
     * @return
     */
    private String getPasswordByUserName(String userName){
        User user = userDao.getUserByUserName(userName);
        if(user != null){
            return user.getPassword();
        }
        return null;
    }



    private Set<String> getRolesByUserName(String username){
        List<String> list = userDao.queryRoleByUserName(username);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }

    private Set<String> getPermissionsByUserName(String username){
        Set<String> sets = new HashSet<String>();
        return sets;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String userName = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = getRolesByUserName(userName);
        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.从主体传过来的认证信息中，获取用户名
        String userName = (String)authenticationToken.getPrincipal();
        String pp = new String((char[]) authenticationToken.getCredentials());
        System.out.println(pp);
        String password = userMap.get(userName);
        SimpleAuthenticationInfo authenticationInfo =
                new SimpleAuthenticationInfo("Mark",password,"customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return authenticationInfo;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("1234567","Mark");
        System.out.println(md5Hash.toString());
    }
}
