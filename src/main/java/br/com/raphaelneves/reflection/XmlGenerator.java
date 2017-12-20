package br.com.raphaelneves.reflection;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

public class XmlGenerator {

    public static String toXML(Object object) throws Exception{
        StringBuilder builder = new StringBuilder();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        builder.append("<" + clazz.getSimpleName().toLowerCase() + "> \n");

        for(Field field : fields){
            field.setAccessible(true);
            if(List.class.isAssignableFrom(field.get(object).getClass())){
                builder.append("<" + field.getName() + "> \n");
                for(Object obj : ((Collection<Object>)field.get(object))){
                    builder.append(toXML(obj));
                }
                builder.append("</" + field.getName() + "> \n");
                break;
            }
            builder.append("<" + field.getName() + ">");
            builder.append(field.get(object));
            builder.append("</" + field.getName() + "> \n");
        }

        builder.append("</" + clazz.getSimpleName().toLowerCase() + ">\n");

        return builder.toString();
    }

}
