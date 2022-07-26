package atguigu.utils;

import atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//封装方法，到时候可以调用,吧Map的值注入到javabean属性中，让bean获取参数
public class WebUtils {
    public  static <T>T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入之后"+bean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
    public static int parseInt(String a,int de){
        if(a==null)return de;
        int w= Integer.parseInt(a);
        return w;
    }
}
