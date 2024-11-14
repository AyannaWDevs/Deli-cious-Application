package src.enums;

public enum CheeseType {
    AMERICAN(size -> size.calculateExtraPrice("CHEESE")), PROVOLONE, CHEDDAR, SWISS
}
