package teamproject.team.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Data
@Getter
@Setter
public class Board {

    private Long id;
    private int ranks;
    private String title;
    private String content;

}
