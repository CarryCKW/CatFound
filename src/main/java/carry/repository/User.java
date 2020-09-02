package carry.repository;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {


    @Size(min = 3,max = 30)
    private String name;

    //校验密码：只能输入6-20个字母、数字、下划线
    @Pattern(regexp = "^(\\w){6,20}$",message = "只能输入6-20个字母、数字、下划线")
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
