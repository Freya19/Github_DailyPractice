package gepeng18.笔试.模拟考试.注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ClassAno {
    String value();
}
