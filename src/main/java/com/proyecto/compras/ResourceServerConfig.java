package com.proyecto.compras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${security.jwt.resource-ids}")
    private String resourceIds;

    @Autowired
    private  ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds)
                .tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(new AuthException())
                .and()
                .requestMatchers()
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs/**").authenticated()
                .antMatchers("/clientes/**").authenticated()
                .antMatchers("/detallepedidos/**").authenticated()
                .antMatchers("/formaspagos/**").authenticated()
                .antMatchers("/marcas/**").authenticated()
                .antMatchers("/pedidos/**").authenticated()
                .antMatchers("/productos/**").authenticated()
                .antMatchers("/tipoentregas/**").authenticated()
                .antMatchers("/tokens/**").permitAll();
    }
}
