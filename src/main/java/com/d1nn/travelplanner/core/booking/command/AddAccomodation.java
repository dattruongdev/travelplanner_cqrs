package com.d1nn.travelplanner.core.booking.command;

import com.d1nn.travelplanner.cqrs.abstraction.HandledBy;
import com.d1nn.travelplanner.cqrs.abstraction.command.Command;
import com.d1nn.travelplanner.cqrs.abstraction.command.CommandHandler;
import com.d1nn.travelplanner.response.IResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@HandledBy(handler = AddAccomodationHandler.class)
public record AddAccomodation(String name,
                              String location,
                              Date checkInDate,
                              Date checkOutDate,
                                double pricePerNight,
                                int availableRoom
                              ) implements Command<ResponseEntity<IResponse>> {

}

@Service
class AddAccomodationHandler implements CommandHandler<AddAccomodation, ResponseEntity<IResponse>> {
    @Override
    public ResponseEntity<IResponse> handle(AddAccomodation command) {
        return null;
    }
}