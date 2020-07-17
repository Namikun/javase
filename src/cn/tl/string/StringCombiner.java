package cn.tl.string;

/**
 * Created by Administrator on 2016/7/7.
 */
public class StringCombiner {

    private final String delimiter;
    private final String prefix;
    private final String suffix;
    private final StringBuilder builder;

    public StringCombiner(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
        this.builder = new StringBuilder();
    }

    public StringCombiner add(String str) {
        if (builder.length() == 0) {
            builder.append(prefix);
        } else {
            builder.append(delimiter);
        }
        builder.append(str);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        if (other.builder.length() > 0){
            if (builder.length() == 0) {
                builder.append(prefix);
            } else {
                builder.append(delimiter);
            }
            this.builder.append(other.builder, prefix.length(), other.builder.length());
        }
        return this;
    }

    @Override
    public String toString() {
        if (builder.length() == 0) {
            builder.append(prefix);
        }
        return builder.append(suffix).toString();
    }

}
