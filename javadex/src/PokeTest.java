import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PokeTest {

    @Getter
    @Setter
    private String count;

    @Getter
    @Setter
    private String next;

    @Getter
    @Setter
    private String previous;

    @Getter
    @Setter
    private List<Result> results;

}
