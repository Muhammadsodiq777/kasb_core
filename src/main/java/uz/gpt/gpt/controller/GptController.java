package uz.gpt.gpt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.gpt.gpt.dto.request.ChatRequestDto;
import uz.gpt.gpt.service.GtpService;

import java.io.IOException;

@RestController
@RequestMapping("/v1/gpt")
@RequiredArgsConstructor
public class GptController {

    private final GtpService service;

    @GetMapping("/get/professions-list")
    public ResponseEntity<?> getProfessions() {
        return ResponseEntity.ok(service.getProfessions());
    }

    @PostMapping("/chat")
    public ResponseEntity<?> chatWithGpt(@RequestBody ChatRequestDto dto) throws IOException {
        return ResponseEntity.ok(service.chatWithGPT(dto));
    }

}
