package com.example.tdd.chap07.sample;

import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AutoDebitRegister {

    private final CardNumberValidator validator;
    private final AutoDebitInfoRepository repository;

    public RegisterResult register(AutoDebitRequest request) {
        CardValidity validity = validator.validate(request.cardNumber());
        if (validity != CardValidity.VALID) {
            return RegisterResult.error(validity);
        }

        Optional<AutoDebitInfo> info = repository.findByUserId(request.userId());

        info.ifPresentOrElse(
            result -> result.changeCardNumber(request.cardNumber()),
            () -> repository.save(getNewInfo(request))
        );

        return RegisterResult.success();
    }

    private AutoDebitInfo getNewInfo(AutoDebitRequest request) {
        return AutoDebitInfo.builder()
            .userId(request.userId())
            .cardNumber(request.cardNumber())
            .currentDate(LocalDate.now())
            .build();
    }


}
