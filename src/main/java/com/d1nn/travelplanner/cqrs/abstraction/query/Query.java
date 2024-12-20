package com.d1nn.travelplanner.cqrs.abstraction.query;

import com.d1nn.travelplanner.cqrs.abstraction.Dispatchable;

public interface Query<TResult> extends Dispatchable<TResult> {
}
