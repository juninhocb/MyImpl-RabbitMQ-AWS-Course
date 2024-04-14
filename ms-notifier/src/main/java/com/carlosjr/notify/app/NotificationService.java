package com.carlosjr.notify.app;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class NotificationService {

    final AmazonSNS amazonSNS;
    void notifySns(String telephone, String msg){
        var publishRequest = new PublishRequest()
                .withMessage(msg)
                .withPhoneNumber(telephone);

        amazonSNS.publish(publishRequest);
    }

}
