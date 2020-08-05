package cn.tl.effective.chapter6;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author namikun
 * @date 2020/7/21
 * <p>
 * EnumMap代替数组
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public static enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> map = Stream.of(values()).collect(Collectors.groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class), Collectors.toMap(t -> t.to, t -> t)));

        public static Transition get(Phase from, Phase to) {
            return map.get(from).get(to);
        }

    }

}
