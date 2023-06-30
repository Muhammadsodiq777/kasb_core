package uz.gpt.gpt.dto.gpt_response_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatCompletionResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;
}



