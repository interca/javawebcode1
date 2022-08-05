package com.it.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mpconfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //定义拦截器
        MybatisPlusInterceptor mybatisPlusInterceptor=new MybatisPlusInterceptor();
        //添加具体拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
