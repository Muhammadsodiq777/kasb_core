package uz.gpt.gpt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse<T> {

    private boolean success;

    private Integer code;

    private String message;

    private T data;
}
