package ru.springsecuritynew.springsecuritynew.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springsecuritynew.springsecuritynew.models.Person;
import ru.springsecuritynew.springsecuritynew.repositories.PeopleRepository;

@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PasswordEncoder passwordEncoder) {
        this.peopleRepository = peopleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
public void register(Person person){
      String encodedPassword=  passwordEncoder.encode(person.getPassword());
      person.setPassword(encodedPassword);
      person.setRole("ROLE_USER");
        peopleRepository.save(person);

}


}
