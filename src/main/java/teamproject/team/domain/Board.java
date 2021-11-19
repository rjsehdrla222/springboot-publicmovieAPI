package teamproject.team.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Board {

    private Long id;
    private int ranks;
    private String upload_day;
    private String attendance;
    private String title;
    private String content;

}
