package com.d1nn.travelplanner.cqrs.abstraction;

public interface DispatchableHandler {
  <TResult> TResult dispatch(Dispatchable<TResult> dispatchable);
}
