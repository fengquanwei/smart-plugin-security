package com.fengquanwei.plugin.security.realm;

import com.fengquanwei.framework.helper.DatabaseHelper;
import com.fengquanwei.plugin.security.SecurityConfig;
import com.fengquanwei.plugin.security.password.Md5CredentialsMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;

/**
 * 基于 Smart 的 JDBC Realm（需要提供相关 smart.plugin.security.jdbc.* 配置项）
 *
 * @author fengquanwei
 * @create 2017/12/12 11:07
 **/
public class SmartJdbcRealm extends JdbcRealm {
    public SmartJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }
}
