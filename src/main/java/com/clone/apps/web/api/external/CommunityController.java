package com.clone.apps.web.api.external;

import com.clone.apps.web.api.ExternalContextController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kh.jin on 2019. 10. 24.
 */
@RestController
public class CommunityController implements ExternalContextController {
    private final Logger log = LoggerFactory.getLogger(CommunityController.class);
}