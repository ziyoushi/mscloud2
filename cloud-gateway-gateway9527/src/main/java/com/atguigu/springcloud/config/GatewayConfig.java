package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author changchen
 * @create 2020-03-23 10:44
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置一个id为route_name的路由规则
     * 当访问地址为localhost:9528/guonei时会自动转发到http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baidu",
                r -> r.path("/guonei").
                        uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

}
