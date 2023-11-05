package com.juliogomes.SaloonHairSystem.controllers;

import com.juliogomes.SaloonHairSystem.entity.user.RegisterDTO;
import com.juliogomes.SaloonHairSystem.entity.user.AuthenticationDTO;
import com.juliogomes.SaloonHairSystem.entity.user.LoginResponseDTO;
import com.juliogomes.SaloonHairSystem.entity.user.User;
import com.juliogomes.SaloonHairSystem.repository.UserRepository;
import com.juliogomes.SaloonHairSystem.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        //creation token
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);
        return ResponseEntity.ok().build();

        }
    @GetMapping("/user/{login}")
    public ResponseEntity<User> getUser(@PathVariable String login){
        User user = (User) this.repository.findByLogin(login);
        if(user == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{login}")
    public ResponseEntity deleteUser(@PathVariable String login){
        User user = (User) this.repository.findByLogin(login);
        if(user == null) return ResponseEntity.notFound().build();

        this.repository.delete(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/me")
    public ResponseEntity<User> getAuthenticatedUser(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }



}
