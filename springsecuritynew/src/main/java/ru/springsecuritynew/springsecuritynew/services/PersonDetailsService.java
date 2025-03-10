package ru.springsecuritynew.springsecuritynew.services;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.springsecuritynew.springsecuritynew.models.Person;
import ru.springsecuritynew.springsecuritynew.repositories.PeopleRepository;
import ru.springsecuritynew.springsecuritynew.security.PersonDetails;


import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
  private final PeopleRepository peopleRepository;
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<Person> person= peopleRepository.findByUserName(username);
      if(person.isEmpty())
          throw new UsernameNotFoundException("User not found");
      return new PersonDetails(person.get());
    }



    public void findById(int id){
      System.out.println(peopleRepository.findById(id));
    }
}
