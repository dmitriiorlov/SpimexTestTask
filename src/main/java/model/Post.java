package model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    public Integer id;
    public Integer userId;
    public String title;
    public String body;
}
