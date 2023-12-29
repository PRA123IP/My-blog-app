package com.myblogApp.Controller;

import com.myblogApp.Dto.SignUPDto;
import com.myblogApp.Entity.Role;
import com.myblogApp.Entity.User;
import com.myblogApp.Payload.JWTAuthResponse;
import com.myblogApp.Payload.LoginDto;

import com.myblogApp.Repository.RoleRepository;
import com.myblogApp.Repository.UserRepository;
import com.myblogApp.Secrity.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtTokenProvider.generateToken(authentication);

       return ResponseEntity.ok( new JWTAuthResponse(token));
    }


    @PostMapping("/signUp")
    public ResponseEntity<?> registerUser(@RequestBody SignUPDto signUPDto)
    {
        // add check user name
        if(userRepository.existsByUsername(signUPDto.getUsername()))
        {
            return new ResponseEntity<>("username already exixts ",HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUPDto.getEmail()))
        {
            return new ResponseEntity<>("Email already exixts ",HttpStatus.BAD_REQUEST);
        }

        User user=new User();

        user.setName(signUPDto.getName());
        user.setEmail(signUPDto.getEmail());
        user.setUsername(signUPDto.getUsername());
        user.setPassword(passwordEncoder.encode(signUPDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));// role  object convert in to  Set using Collections
        userRepository.save(user);

        return new ResponseEntity<>("user register successfully",HttpStatus.ACCEPTED);

    }

}

