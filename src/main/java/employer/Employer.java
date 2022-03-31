package employer;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Employer {
    private int id;
    private String name, lastName;
}
