package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class PreferenceHandler extends GeneralException {
    public PreferenceHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
