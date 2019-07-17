package com.clone.apps.global.events.listeners;

import com.clone.apps.global.events.MemberRegistrationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by kh.jin on 2019. 7. 17.
 */
@Component
public class MemberRegistrationEventListener implements ApplicationListener<MemberRegistrationEvent> {

    @Override
    public void onApplicationEvent(MemberRegistrationEvent event) {

    }
}
