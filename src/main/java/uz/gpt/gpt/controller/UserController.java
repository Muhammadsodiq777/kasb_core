package uz.gpt.gpt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.gpt.gpt.domain.UserEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/get/all-users")
    public ResponseEntity<?> getAllBooks() {
        try {
            List<UserEntity> userEntities = Arrays.asList(
                    new UserEntity(1L, "Muhammad Sodiq", LocalDateTime.now()),
                    new UserEntity(2L, "Akobir", LocalDateTime.now()),
                    new UserEntity(3L, "Valisher", LocalDateTime.now()),
                    new UserEntity(4L, "Shava", LocalDateTime.now()),
                    new UserEntity(5L, "Sher", LocalDateTime.now()));
            return ResponseEntity.ok(userEntities);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
        }
    }

}
