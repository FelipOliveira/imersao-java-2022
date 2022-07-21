import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String url;
}
