package com.ms.email.application.port;

import com.ms.email.application.domain.Email;

public interface SendEmailServicePort {

    void sendEmailSmtp(Email email);
}
