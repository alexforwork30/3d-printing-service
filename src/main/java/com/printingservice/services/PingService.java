package com.printingservice.services;

import com.printingservice.models.Ping;
import com.printingservice.repositories.PingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PingService {
    private final PingRepository pingRepository;

    public Ping createPing(Ping ping) {
        return pingRepository.save(ping);
    }

    public Ping findByMessage(String message) {
        return pingRepository.findByMessage(message);
    }
}
