package olympics;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Athlete {
    private int code;
    private String name, nation;
    private double height;
    private Date birthdate;
}
