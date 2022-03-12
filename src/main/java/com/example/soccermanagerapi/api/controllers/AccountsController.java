package com.example.soccermanagerapi.api.controllers;

import com.example.soccermanagerapi.business.abstracts.AccountService;
import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.core.utilities.results.ErrorDataResult;
import com.example.soccermanagerapi.core.utilities.results.Result;
import com.example.soccermanagerapi.core.utilities.results.SuccessResult;
import com.example.soccermanagerapi.entities.concretes.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private AccountService accountService;

    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getall")
    public DataResult<List<Account>> getAll(){
        return this.accountService.getAll();
    }

    @PostMapping("/createAccount")
    public Result createAccount(@RequestBody Account account){
         this.accountService.createAccount(account);
         return new SuccessResult("Account created. New team created.");
    }

    //AOP --> Global Exception Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationsErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationsErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationsErrors, "Auth errors.");
        return errors;
    }

    //TODO: Login icin jwt ile filter yazılacak
}
