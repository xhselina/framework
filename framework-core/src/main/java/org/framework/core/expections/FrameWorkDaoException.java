package org.framework.core.expections;

/**
 * 业务异常
 *
 * @version : Ver 1.0
 * @author    : <a href="mailto:dejianliu@ebnew.com">dejianliu</a>
 * @date    : 2015-4-20 上午11:06:12
 */
public class FrameWorkDaoException extends BaseException {

    private static final long serialVersionUID = 1L;

    public FrameWorkDaoException() {
        super();
    }

    public FrameWorkDaoException(String message) {
        super(message);
    }

    public FrameWorkDaoException(Throwable cause) {
        super(cause);
    }

    public FrameWorkDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameWorkDaoException(String message, Throwable cause, String code,Object[] values) {
        super(message, cause, code, values);
    }

}
