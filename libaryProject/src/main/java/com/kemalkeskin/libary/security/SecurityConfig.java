package com.kemalkeskin.libary.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private  CustomUserDetailService customUserDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      http

              .authorizeHttpRequests(auth->auth    // http isteklerine yetki verme kısmı
             // bu yazdığım şey için doğrulama yapma demek.
              .anyRequest().authenticated()// geri kalan herşey için doğrulama zorunlu


              );

        // http.formLogin form tabanlı bir doğrulamayı etkinleştirir. örneğin username ve şifre gibi
        //Customizer.withDefaults() ise requestmapping default olarak /login olarak belirlenir,
        //Hatalı girişlerde /login?error URL'sine yönlendirme.
        //Çıkış yapıldıktan sonra /login?logout URL'sine yönlendirme.

        // özelleştirmek istersek
        //http
        //    .formLogin(form -> form
        //        .loginPage("/custom-login") // Özelleştirilmiş giriş sayfası
        //        .usernameParameter("user") // Kullanıcı adı alanını özelleştirme
        //        .passwordParameter("pass") // Şifre alanını özelleştirme
        //        .defaultSuccessUrl("/home", true) // Giriş başarılıysa yönlendirme
        //        .failureUrl("/custom-login?error") // Hatalı giriş durumunda yönlendirme
        //    );

        http.formLogin(Customizer.withDefaults());

        //http.httpBasic(): Basic Authentication özelliğini etkinleştirir.
        //Customizer.withDefaults(): Varsayılan ayarlarla çalışır. Bu ayarlar şunları içerir:
       // İstemci, her istekte Authorization başlığıyla kullanıcı adı ve şifre gönderir.
       // Kullanıcı adı ve şifre doğrulama işlemi için varsayılan Spring Security yapılandırması kullanılır.
        // bu kolay çözülebildiği için https ile kullanılmalıdır ve özelleştirilmelidir.
        http.httpBasic(Customizer.withDefaults());

//      Customizer<CsrfConfigurer<HttpSecurity>>crsfCustomizer=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//          @Override
//          public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//              customizer.disable();
//          }
//      };
//       eğer csrf boylede özelleştirebiliriz
//        http.csrf(crsfCustomizer);
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(customUserDetailService);
        return provider;
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder(12);
    }

}
