package br.com.raphaelneves.reflection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XmpApplicationTester {

    public static void main(String... args) throws Exception {

        User user = new User();
        user.setName("Raphael");
        user.setUsername("raphael");
        user.setCreatedOn(new Date());
        user.setActive(true);

        List<Profile> profiles = new ArrayList<Profile>();

        Profile admin = new Profile();
        admin.setName("Administrtor");
        admin.setActive(true);

        profiles.add(admin);
        user.setProfiles(profiles);

        System.out.println(XmlGenerator.toXML(user));

    }
}
