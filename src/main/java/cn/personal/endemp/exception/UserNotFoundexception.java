package cn.personal.endemp.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ Author     ：liu
 * @ Date       ：Created in 19:45 2019/5/17
 * @ Description：用户没有被发现
 * @ Modified By：
 * @Version: $
 */
public class UserNotFoundexception  extends UsernameNotFoundException {

    String message;

    public UserNotFoundexception(String msg) {
        super(msg);

        this.message = msg;
    }

    public String showMessage()
    {
        System.err.println(message);

        return message;
    }

}
