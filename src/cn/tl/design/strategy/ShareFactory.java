package cn.tl.design.strategy;

import java.util.Map;

public class ShareFactory {

    public static Share getInstance(String type) {
        Map<String, String> allTypes = ShareEnum.getAllTypes();
        String className = allTypes.get(type);
        try {
            return (Share) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
