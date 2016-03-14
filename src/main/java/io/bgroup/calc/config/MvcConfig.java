package io.bgroup.calc.config;

import io.bgroup.calc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("io.bgroup.calc")

public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/pages/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/pages/images/").setCachePeriod(31556926);
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/pages/images/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/pages/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/gif/**").addResourceLocations("/WEB-INF/pages/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/demo-files/**").addResourceLocations("/WEB-INF/pages/demo-files/").setCachePeriod(31556926);
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/pages/fonts/").setCachePeriod(31556926);
    }

    @Bean(name = "calc")
    public Calc calc() {
        Calc calc = new Calc();
        return calc;
    }
}