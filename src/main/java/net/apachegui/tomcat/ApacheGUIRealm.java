package net.apachegui.tomcat;

import net.apachegui.db.SettingsDao;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Request;
import org.apache.catalina.deploy.SecurityConstraint;
import org.apache.catalina.realm.JDBCRealm;

public class ApacheGUIRealm extends JDBCRealm
{
    @Override
    public SecurityConstraint[] findSecurityConstraints(Request request, Context context) {
        String enabled = SettingsDao.getInstance().getSetting("authenticationEnabled");
        if(enabled != null && enabled.equals("false")) {
            return null;
        }

        return super.findSecurityConstraints(request, context);
    }


}
