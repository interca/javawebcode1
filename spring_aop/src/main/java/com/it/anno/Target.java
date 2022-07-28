package com.it.anno;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//将目标对象交给spring容器
@Component("target")
public class Target  implements TargetInterface {

    @Override
    public void save() {
        System.out.println("save running");
    }
}
