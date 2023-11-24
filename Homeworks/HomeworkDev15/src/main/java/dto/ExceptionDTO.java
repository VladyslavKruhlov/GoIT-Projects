package dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDTO {
    private Long id;
    private String message;
    private Integer code;
}
