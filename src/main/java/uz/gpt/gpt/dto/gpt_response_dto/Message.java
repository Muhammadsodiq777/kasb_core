package uz.gpt.gpt.dto.gpt_response_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String role;
    private String content;
}