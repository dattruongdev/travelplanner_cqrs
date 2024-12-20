package com.d1nn.travelplanner.core.auth.command;

import com.d1nn.travelplanner.response.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.d1nn.travelplanner.cqrs.abstraction.HandledBy;
import com.d1nn.travelplanner.cqrs.abstraction.command.Command;
import com.d1nn.travelplanner.cqrs.abstraction.command.CommandHandler;
import com.d1nn.travelplanner.response.ApiResponse;
import com.d1nn.travelplanner.response.ErrorResponse;
import com.d1nn.travelplanner.response.IResponse;
import com.d1nn.travelplanner.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

@HandledBy(handler = LoginCommandHandler.class)
public record LoginCommand(String username, String password) implements Command<ResponseEntity<IResponse>> {
}

@RequiredArgsConstructor
@Service
class LoginCommandHandler implements CommandHandler<LoginCommand, ResponseEntity<IResponse>> {
  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;

  @ResponseBody
  public ResponseEntity<IResponse> handle(LoginCommand command) {
    try {
      Authentication auth = authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(command.username(), command.password()));

      String token = jwtUtils.generateToken(auth);
      return ResponseEntity.ok(new ApiResponse(200, "Successfully signed in", new JwtResponse(token)));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(new ErrorResponse(400, e.getMessage()));
    }
  }
}
