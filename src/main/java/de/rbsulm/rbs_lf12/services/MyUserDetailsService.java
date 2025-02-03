package de.rbsulm.rbs_lf12.services;

import de.rbsulm.rbs_lf12.model.MyUserDetails;
import de.rbsulm.rbs_lf12.model.User;
import de.rbsulm.rbs_lf12.mysql.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user); // You need to create a MyUserDetails class that implements UserDetails
    }
}