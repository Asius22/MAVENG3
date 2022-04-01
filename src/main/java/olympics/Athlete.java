package olympics;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.sql.Date;

@Data @RequiredArgsConstructor @Builder
public class Athlete {
    private int code;
    private String name, nation;
    private float height;
    private Date birthdate;
}
