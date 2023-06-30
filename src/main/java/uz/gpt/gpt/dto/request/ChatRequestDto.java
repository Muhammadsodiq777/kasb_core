package uz.gpt.gpt.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRequestDto {

    private Integer code;

    private String request;
}
