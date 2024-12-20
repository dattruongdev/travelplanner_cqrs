package com.d1nn.travelplanner.cqrs.abstraction;

public interface BaseHandler<TDispatchable extends Dispatchable<TResult>, TResult> {
  TResult handle(TDispatchable dispatchable);
}
