package org.framework.core.util.BelongTo;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/1/27 14:52.
 */
public class ResultDto {
    private String errNum;
    private String retMsg;
    private PhoneInfo retData;

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public PhoneInfo getRetData() {
        return retData;
    }

    public void setRetData(PhoneInfo retData) {
        this.retData = retData;
    }
}
