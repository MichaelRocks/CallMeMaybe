package io.michaelrocks.callmemaybe;

public final class FormatParameters {
  public static final FormatParameters DEFAULT = newBuilder().build();

  private final String region;

  FormatParameters(final Builder builder) {
    this.region = builder.region;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getRegion() {
    return region;
  }

  public static class Builder {
    String region;

    Builder() {
      // Nothing to do.
    }

    public Builder region(final String region) {
      this.region = region;
      return this;
    }

    public FormatParameters build() {
      return new FormatParameters(this);
    }
  }
}
