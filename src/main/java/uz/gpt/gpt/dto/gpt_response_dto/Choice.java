package uz.gpt.gpt.dto.gpt_response_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
    private int index;
    private Message message;
    private String finish_reason;
}