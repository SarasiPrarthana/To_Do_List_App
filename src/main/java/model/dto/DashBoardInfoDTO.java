package model.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DashBoardInfoDTO {

    private String id;
    private String title;
    private String description;
    private String date;
}
