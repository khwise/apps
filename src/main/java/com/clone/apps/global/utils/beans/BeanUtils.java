package com.clone.apps.global.utils.beans;


import org.springframework.context.ApplicationContext;

/**
 * Created by kh.jin on 2019. 7. 4.
 */
public class BeanUtils {

    public static Object getBean(Class<?> classType) {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        return applicationContext.getBean(classType);
    }
}
