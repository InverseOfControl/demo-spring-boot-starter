package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnClass(DemoBean.class)
@ConditionalOnProperty(prefix = "demo", value = "enabled", matchIfMissing = true)
public class DemoAutoConfiguration {

    private final DemoProperties demoProperties;

    public DemoAutoConfiguration(DemoProperties demoProperties){
        this.demoProperties = demoProperties;
    }

    @Bean
    @ConditionalOnMissingBean(DemoBean.class)
    public DemoBean demoProperties(){
        DemoBean demoBean = new DemoBean();
        demoBean.setName(demoProperties.getName());
        demoBean.setAge(demoProperties.getAge());
        return demoBean;
    }

}
