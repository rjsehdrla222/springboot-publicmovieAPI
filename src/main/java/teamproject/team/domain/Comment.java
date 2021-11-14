package teamproject.team.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private Long id;
    private String title;
    private String comment;
    private String name;
    private String pw;

}
