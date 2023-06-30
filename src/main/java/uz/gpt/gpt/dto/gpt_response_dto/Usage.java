package uz.gpt.gpt.dto.gpt_response_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
}