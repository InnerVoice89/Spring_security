package ru.springsecuritynew.springsecuritynew.security;

//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import ru.springsecuritynew.springsecuritynew.services.PersonDetailsService;


import java.util.Collections;
//@Component
public class AuthProviderImpl{
//    private final PersonDetailsService personDetailsService;
//
//    public AuthProviderImpl(PersonDetailsService personDetailsService) {
//        this.personDetailsService = personDetailsService;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        String userName=authentication.getName();
//       UserDetails personDetails= personDetailsService.loadUserByUsername(userName);
//       String password=authentication.getCredentials().toString();
//      if(!password.equals(personDetails.getPassword())){
//          throw new BadCredentialsException("Incorrect fucking password");
//      }
//      return new UsernamePasswordAuthenticationToken(personDetails,password, Collections.emptyList());
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true ;
//    }
}
