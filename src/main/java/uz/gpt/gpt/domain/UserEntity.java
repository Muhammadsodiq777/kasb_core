package uz.gpt.gpt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private Long id;

    private String name;

    private LocalDateTime createdAt;
}
