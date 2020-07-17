package cn.tl.design.strategy;

import java.util.HashMap;
import java.util.Map;

public enum ShareEnum {

    WECHAT("wechat", WechatShare.class.getName()),
    QQ("qq", QQShare.class.getName());

    private String type;
    private String className;
    private static final Map<String, String> allTypes = new HashMap<>(4);

    static {
        ShareEnum[] values = ShareEnum.values();
        for (ShareEnum shareEnum : values) {
            allTypes.put(shareEnum.getType(), shareEnum.getClassName());
        }
    }

    ShareEnum(String type, String className) {
        this.type = type;
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public String getClassName() {
        return className;
    }

    public static Map<String, String> getAllTypes() {
        return allTypes;
    }
}
