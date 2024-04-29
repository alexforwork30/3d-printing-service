package com.printingservice.controllers;

import com.printingservice.models.Ping;
import com.printingservice.services.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pings")
@RequiredArgsConstructor
public class PingController {
  private final PingService pingService;

  @GetMapping
  public String ping() {
    return "Pong!";
  }

  @GetMapping("/{message}")
  public Ping ping(@PathVariable String message) {
    return pingService.findByMessage(message);
  }

  @PostMapping
  public Ping createPing(@RequestBody Ping ping) {
    return pingService.createPing(ping);
  }
}
