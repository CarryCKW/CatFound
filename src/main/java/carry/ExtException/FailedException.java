package carry.ExtException;

import org.springframework.dao.DataAccessException;

public class FailedException extends DataAccessException {
    private String msg;

    public FailedException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
