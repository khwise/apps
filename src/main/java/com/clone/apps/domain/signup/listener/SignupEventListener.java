package com.clone.apps.domain.signup.listener;

import com.clone.apps.domain.signup.events.SignupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by kh.jin on 2019. 9. 12.
 * 회원가입 후 인증 메일을 발송하는 Event Listener 클래스.
 */

//TODO : Listener 패키지를 각 도메인에 두는게 맞을 것인지 고민
@Component
public class SignupEventListener {
    private final Logger log = LoggerFactory.getLogger(SignupEventListener.class);

    // TODO : phase = TransactionPhase.AFTER_COMMIT 외 다른 옵션 테스트
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, classes = SignupEvent.class)
    public void handle(SignupEvent event) {
        log.debug("event : {}", event);
        // 인증번호 생성
        // DB 저장
        // 이메일 발송 ......
    }
}