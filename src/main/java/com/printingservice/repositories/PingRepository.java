package com.printingservice.repositories;

import com.printingservice.models.Ping;
import org.springframework.stereotype.Repository;

@Repository
public interface PingRepository extends BaseRepository<Ping, Long> {
    Ping findByMessage(String message);
}
