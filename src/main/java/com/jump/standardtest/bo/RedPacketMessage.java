package com.jump.standardtest.bo;

import java.io.Serializable;

/**
 * 〈红包信息〉
 *
 * @author LiLin
 * @date 2020/8/28 0028
 */
public class RedPacketMessage implements Serializable {
    private static final long serialVersionUID = -2691029465463855366L;
    /**
     * 红包 ID
     */
    private long redPacketId;

    /**
     * 创建时间戳
     */
    private long timestamp;

    public RedPacketMessage() {

    }

    public RedPacketMessage(long redPacketId) {
        this.redPacketId = redPacketId;
        this.timestamp = System.currentTimeMillis();
    }

    public long getRedPacketId() {
        return redPacketId;
    }

    public long getTimestamp() {
        return timestamp;
    }

}