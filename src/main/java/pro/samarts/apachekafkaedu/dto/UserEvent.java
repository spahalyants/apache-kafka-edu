package pro.samarts.apachekafkaedu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {
    private Long userId;
    private String userName;
    private String action; // e.g., "LOGIN", "LOGOUT"
}
