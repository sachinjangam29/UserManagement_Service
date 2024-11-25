package org.warranty.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.warranty.user_service.model.Account;
import org.warranty.user_service.payload.request.AccountRequest;
import org.warranty.user_service.payload.response.AccountResponse;
import org.warranty.user_service.service.AccountService;


@RequestMapping("/api/user")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public ResponseEntity<String> saveUserDetails(@RequestBody AccountRequest accountRequest){
        Account account= accountService.saveUserDetails(accountRequest);
        if(account != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User Details saved successfully with the user id " + account.getUserId());
        } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountRequest accountRequest){
       String jwt = accountService.login(accountRequest);
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/all-users")
    public Page<AccountResponse> getAllUsersData(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "5") int size,
                                                 @RequestParam(value = "sortby", defaultValue = "userId") String sortBy,
                                                 @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection){
       return accountService.getAllUsers(page, size, sortBy, sortDirection);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> printHello(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("hello this is sachin");
    }

    @DeleteMapping("/all-users")
    public ResponseEntity<String> deleteAllUserDetails(){
        accountService.deleteAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body("All users deleted succesfully");
    }
}
