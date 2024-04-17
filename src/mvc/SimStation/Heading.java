package mvc.SimStation;

import mvc.Utilities;

public enum Heading {
    NORTH,EAST,SOUTH,WEST;
    public static Heading random() {
        int rand= Utilities.rng.nextInt(4)+1;
        return switch (rand) {
            case (1) -> NORTH;
            case (2) -> EAST;
            case (3) -> SOUTH;
            default -> WEST;
        };
    }

}