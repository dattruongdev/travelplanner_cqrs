package com.d1nn.travelplanner.cqrs.abstraction.command;

import com.d1nn.travelplanner.cqrs.abstraction.BaseHandler;
import com.d1nn.travelplanner.cqrs.abstraction.Dispatchable;

public interface CommandHandler<TCommand extends Dispatchable<TResult>, TResult>
    extends BaseHandler<TCommand, TResult> {
}
