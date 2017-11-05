package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.example.demo"})
//@ConfigurationProperties
@Controller
/**
 * @EnableAutoConfiguration
 * 这个注释告诉SpringBoot“猜”你将如何想配置Spring,基于你已经添加jar依赖项。如果spring-boot-starter-web已经添加Tomcat和Spring MVC,这个注释自动将假设您正在开发一个web应用程序并添加相应的spring设置。

　　自动配置被设计用来和“Starters”一起更好的工作,但这两个概念并不直接相关。您可以自由挑选starter依赖项以外的jar包，springboot仍将尽力自动配置您的应用程序。

　　spring通常建议我们将main方法所在的类放到一个root包下，@EnableAutoConfiguration（开启自动配置）注解通常都放到main所在类的上面，下面是一个典型的结构布局：
 +- example
     +- myproject
         +- Application.java
         |
         +- domain
         |   +- Customer.java
         |   +- CustomerRepository.java
         |
         +- service
         |   +- CustomerService.java
         |
         +- web
             +- CustomerController.java
　　这样@EnableAutoConfiguration可以从逐层的往下搜索各个加注解的类，例如，你正在编写一个JPA程序（如果你的pom里进行了配置的话），spring会自动去搜索加了@Entity注解的类，并进行调用
 * 
 * 
 * @SpringbootApplication
 　　使用@SpringbootApplication注解  可以解决根类或者配置类（我自己的说法，就是main所在类）头上注解过多的问题，一个@SpringbootApplication相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan 并具有他们的默认属性值 
 * 
 * 总结,@EnableAutoConfiguration 作用
从classpath中搜索所有META-INF/spring.factories配置文件然后，将其中org.springframework.boot.autoconfigure.EnableAutoConfiguration key对应的配置项加载到spring容器
只有spring.boot.enableautoconfiguration为true（默认为true）的时候，才启用自动配置
@EnableAutoConfiguration还可以进行排除，排除方式有2中，一是根据class来排除（exclude），二是根据class name（excludeName）来排除
其内部实现的关键点有
1）ImportSelector 该接口的方法的返回值都会被纳入到spring容器管理中
2）SpringFactoriesLoader 该类可以从classpath中搜索所有META-INF/spring.factories配置文件，并读取配置


1.@EnableAutoConfiguration 主要是用来开启自动配置是扫描jar包下，配置了META-INF/spring.factories里面的类和针对当前包以及子包下的自定义组件的（也就是归spring管理的）
2.@ComponengScan是用来配置自定义组件的（也就是归spring管理的），可以指定base路径orBaseClass

如果要加载的类不在@EnableAutoConfiguration下不会被加载，而且@ComponentScan为spring-context包下的类，是已经存在N久的用于在<context:component-scan>
 * 
 * 
 * 
 * 
 * */
public class DemoApplication {
	
	@RequestMapping("test")
	@ResponseBody
	public String say(){
		return "反反复复";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
