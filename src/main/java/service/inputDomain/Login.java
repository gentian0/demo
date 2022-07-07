package service.inputDomain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: kong
 * @Date: 2022/7/6 16:13
 * @Description:
 */

@Getter
@Setter
@ToString
public class Login {
    private String username;
    private String password;
    private String verification;


}
