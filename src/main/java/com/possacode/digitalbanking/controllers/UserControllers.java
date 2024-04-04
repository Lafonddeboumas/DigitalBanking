package com.possacode.digitalbanking.controllers;


import com.possacode.digitalbanking.dtO.UserDto;
import com.possacode.digitalbanking.sevices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibank/v1/users")
@RequiredArgsConstructor
public class UserControllers {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>>findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserDto> findById(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PatchMapping("/validate/{user-id}")
    public ResponseEntity<Integer> validate(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.validateAccount(userId));
    }

    @PatchMapping("/invalidate/{user-id}")
    public ResponseEntity<Integer> invalidate(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(userService.invalidateAccount(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> delete(@PathVariable("user-id") Integer userId){
        userService.delete(userId);
       return ResponseEntity.accepted().build();
    }
}
