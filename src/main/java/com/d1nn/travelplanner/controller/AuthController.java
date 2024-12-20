package com.d1nn.travelplanner.controller;

import com.d1nn.travelplanner.core.auth.command.LoginCommand;
import com.d1nn.travelplanner.core.auth.command.RegisterCommand;
import com.d1nn.travelplanner.cqrs.abstraction.DispatchableHandler;
import com.d1nn.travelplanner.response.IResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.root}/auth")
@RequiredArgsConstructor
@SecurityRequirement(name = "Authorization")
public class AuthController {
    private final DispatchableHandler _dispatchableHandler;

    @PostMapping("/login")
    public ResponseEntity<IResponse> login(@RequestBody LoginCommand command) {
        return _dispatchableHandler.dispatch(command);
    }

    @PostMapping("/register")

    public ResponseEntity<IResponse> register(@RequestBody RegisterCommand command) {
        return _dispatchableHandler.dispatch(command);
    }
}
