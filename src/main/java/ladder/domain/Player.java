package ladder.domain;

import java.util.Objects;

public class Player {
    private final Name name;
    private final Prize prize;

    private Player(Name name, Prize prize) {
        this.name = name;
        this.prize = prize;
    }

    public Player(Name name) {
        this(name, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
