package edu.mum.qtree.controllers;

import edu.mum.qtree.dao.UserRepository;
import edu.mum.qtree.dto.AuthenticationRequestDto;
import edu.mum.qtree.dto.UserAddDto;
import edu.mum.qtree.models.entities.User;
import edu.mum.qtree.models.entities.UserRole;
import edu.mum.qtree.security.jwt.JwtTokenProvider;
import edu.mum.qtree.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @PermitAll
    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequestDto data) {

        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token;

            List<String> s = new ArrayList<>();
            token = jwtTokenProvider.createToken(username, s.add(this.users.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getUserRole().getName())) ;

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PermitAll
    @PostMapping("/signup")
    public User signup(@RequestBody UserAddDto dto) {

           User user = new User();

            user.setId(dto.getId());
            user.setEmail(dto.getEmail());
            user.setName(dto.getName());
            user.setPassword(dto.getPassword());
            user.setIsEnabled(dto.getIsEnabled());
            user.setUserRole(new UserRole(dto.getRoleId()));
            user.setCreatedOn(new Date());
            user.setModifiedOn(new Date());

            return userService.signUp(user);
    }
}