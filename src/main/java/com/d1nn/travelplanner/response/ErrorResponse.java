package com.d1nn.travelplanner.response;

public record ErrorResponse(int errorCode, String message) implements IResponse {
}
