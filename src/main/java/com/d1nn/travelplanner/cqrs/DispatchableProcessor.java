package com.d1nn.travelplanner.cqrs;

import java.util.Map;


import com.d1nn.travelplanner.cqrs.abstraction.BaseHandler;
import com.d1nn.travelplanner.cqrs.abstraction.Dispatchable;
import com.d1nn.travelplanner.cqrs.abstraction.DispatchableHandler;
import com.d1nn.travelplanner.cqrs.abstraction.HandledBy;
import org.springframework.context.ApplicationContext;

public class DispatchableProcessor implements DispatchableHandler {
  private final ApplicationContext _applicationContext;

  public DispatchableProcessor(ApplicationContext applicationContext) {
    _applicationContext = applicationContext;
  }

  @Override
  public <TResult> TResult dispatch(Dispatchable<TResult> dispatchable) {
    HandledBy handledByAnnotation = dispatchable.getClass().getAnnotation(HandledBy.class);

    if (handledByAnnotation == null) {
      throw new IllegalStateException(String.format("No @HandledBy annotation provided for dispatchable %s",
          dispatchable.getClass().getSimpleName()));
    }
    Class<? extends BaseHandler<? extends Dispatchable<?>, ?>> handlerType = handledByAnnotation.handler();
    Map<String, ? extends BaseHandler<? extends Dispatchable<?>, ?>> handlers = _applicationContext.getBeansOfType(handlerType);

    if (handlers.isEmpty()) {
      throw new IllegalStateException(
          String.format("Dispatchable %s has no handler", dispatchable.getClass().getSimpleName()));
    }

    if (handlers.size() > 1) {
      throw new IllegalStateException(
          String.format("Dispatchable %s has more than one handler", dispatchable.getClass().getSimpleName()));
    }

    BaseHandler<Dispatchable<TResult>, TResult> handler = (BaseHandler<Dispatchable<TResult>, TResult>) handlers.values().iterator().next();

    return handler.handle(dispatchable);
  }

}
