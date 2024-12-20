package com.d1nn.travelplanner.cqrs.abstraction.command;

import com.d1nn.travelplanner.cqrs.abstraction.Dispatchable;

public interface Command<TResult> extends Dispatchable<TResult> {
}
