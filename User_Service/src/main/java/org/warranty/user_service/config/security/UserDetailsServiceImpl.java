package org.warranty.user_service.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.warranty.user_service.model.Account;
import org.warranty.user_service.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final AccountRepository accountRepository;

    @Autowired
    public UserDetailsServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserId(userId)
                .orElseThrow( () -> new UsernameNotFoundException("User not found with the username "+userId) );

        return User.builder()
                .username(account.getUserId())
                .password(account.getPassword())
                .authorities("ROLE_" + account.getRole().name())
                .build();
    }
}
