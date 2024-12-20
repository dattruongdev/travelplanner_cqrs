package com.d1nn.travelplanner.core.auth.command;

import com.d1nn.travelplanner.core.auth.dto.UserDto;
import com.d1nn.travelplanner.cqrs.abstraction.HandledBy;
import com.d1nn.travelplanner.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import com.d1nn.travelplanner.core.auth.User;
import com.d1nn.travelplanner.core.auth.UserRepository;
import com.d1nn.travelplanner.cqrs.abstraction.command.Command;
import com.d1nn.travelplanner.cqrs.abstraction.command.CommandHandler;
import com.d1nn.travelplanner.response.IResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@HandledBy(handler = RegisterCommandHandler.class)
public record RegisterCommand(
        String username,
        String password,
        String email,
        String firstName,
        String lastName)
        implements Command<ResponseEntity<IResponse>> {
}

@RequiredArgsConstructor
@Service
class RegisterCommandHandler implements CommandHandler<RegisterCommand, ResponseEntity<IResponse>> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<IResponse> handle(RegisterCommand command) {
        User user = new User();
        user.setUsername(command.username());
        user.setPassword(passwordEncoder.encode(command.password()));
        user.setEmail(command.email());
        user.setFirstName(command.firstName());
        user.setLastName(command.lastName());

        User savedUser = userRepository.save(user);

        UserDto userDto = new UserDto(
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getFirstName(),
                savedUser.getLastName()
        );

        return ResponseEntity.status(201).body(new ApiResponse(201, "User registered", userDto));
    }

}
