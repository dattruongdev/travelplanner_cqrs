package com.d1nn.travelplanner.cqrs.abstraction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandledBy {
  Class<? extends BaseHandler<? extends Dispatchable<?>, ?>> handler();
}
