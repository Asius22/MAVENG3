package olympics;

import lombok.Data;
import java.util.Calendar;
import java.sql.Date;

@Data
public class Athlete {
    private int code;
    private String name, nation;
    private float height;
    private Date birthdate;
}
