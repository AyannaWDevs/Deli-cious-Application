package src.enums;

public enum ToppingType {
    MEAT((size, isAdditional) -> size.calculateExtraPrice("MEAT", isAdditional)),
    CHEESE((size, isAdditional) -> size.calculateExtraPrice("CHEESE", isAdditional));


    private final ExtraPricingStrategy extraPricing;

    ToppingType(ExtraPricingStrategy extraPricing) {
        this.extraPricing = extraPricing;
    }

    public double getPrice(SandwichSize size, boolean isAdditional) {
        return this.extraPricing.getExtraPrice(size, isAdditional);
    }

    interface ExtraPricingStrategy {
        double getExtraPrice(SandwichSize size, boolean isAdditional);
    }
}
