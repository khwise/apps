package com.clone.apps.events;

import org.springframework.context.ApplicationEvent;

/**
 * Created by kh.jin on 2019. 7. 17.
 */
public class MemberRegistrationEvent extends ApplicationEvent {

    public MemberRegistrationEvent(Object source) {
        super(source);
    }
}
