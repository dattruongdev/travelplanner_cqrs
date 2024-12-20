package com.d1nn.travelplanner.cqrs.abstraction.query;

import com.d1nn.travelplanner.cqrs.abstraction.BaseHandler;
import com.d1nn.travelplanner.cqrs.abstraction.Dispatchable;

public interface QueryHandler<TQuery extends Dispatchable<TResult>, TResult>
        extends BaseHandler<TQuery, TResult> {
}
