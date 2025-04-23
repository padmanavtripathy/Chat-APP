package chat_app_backend.service;

import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService{
    @Override
    public String randomOtpGenerator(int otpDegit) {
        Long otp= 0L;
        for(int i = 0; i<otpDegit; i++){
            int random = (int)(Math.random() * 10);
            otp=(otp*10)+random;
        }

        return otp.toString();
    }
}
