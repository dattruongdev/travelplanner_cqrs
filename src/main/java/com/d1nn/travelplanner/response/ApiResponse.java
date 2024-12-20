package com.d1nn.travelplanner.response;

public record ApiResponse(int statusCode, String message, Object data) implements IResponse {
}
