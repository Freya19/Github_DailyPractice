package gepeng18.grammar;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.*;

@Builder
@AllArgsConstructor
class Feed{
    int id;
    int create_time;
    int userId;
    int entityId;  //id
    int entityType; //博客 / 帖子
    int feedType; //点赞

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return userId == feed.userId &&
                entityId == feed.entityId &&
                entityType == feed.entityType &&
                feedType == feed.feedType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, entityId, entityType, feedType);
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id +
                ", create_time=" + create_time +
                ", userId=" + userId +
                ", entityId=" + entityId +
                ", entityType=" + entityType +
                ", feedType=" + feedType +
                '}';
    }
}

public class hashcode{
    public static void main(String[] args) {
        final HashMap<String, String> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("1","1");
        objectObjectHashMap.put("2","2");
        objectObjectHashMap.put("1","2");
        System.out.println(objectObjectHashMap);
    }
}