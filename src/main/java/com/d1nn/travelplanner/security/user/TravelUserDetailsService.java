package com.d1nn.travelplanner.security.user;

import com.d1nn.travelplanner.core.auth.User;
import com.d1nn.travelplanner.core.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(
        Collectors.toList());

    return Optional.ofNullable(user)
        .map(usr -> new TravelUserDetails(usr.getId(), usr.getUsername(), usr.getPassword(), usr.getEmail(), authorities))
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

}
