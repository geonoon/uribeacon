package org.uribeacon.beacon;


import java.net.URISyntaxException;


public class ConfigUriBeacon {

  private final UriBeacon mUriBeacon;
  //TODO(g-ortuno): Add V2 variables
  private ConfigUriBeacon(UriBeacon uriBeacon) {
    mUriBeacon = uriBeacon;
  }

  public static ConfigUriBeacon parseFromBytes(byte[] scanRecordBytes) {
    UriBeacon uriBeacon = UriBeacon.parseFromBytes(scanRecordBytes);
    return new ConfigUriBeacon(uriBeacon);
  }

  public byte[] toByteArray() throws URISyntaxException {
    return mUriBeacon.toByteArray();
  }

  public String getUriString() {
    return mUriBeacon.getUriString();
  }

  public byte getTxPowerLevel() {
    return mUriBeacon.getTxPowerLevel();
  }

  public byte getFlags() {
    return mUriBeacon.getFlags();
  }

  public byte[] getUriBytes() throws URISyntaxException {
    return mUriBeacon.getUriBytes();
  }

  public static final class Builder {

    private UriBeacon.Builder mBuilder = new UriBeacon.Builder();
    //TODO(g-ortuno): Add the rest of the V2 characteristics

    /**
     * Add flags to the ConfigUriBeacon advertised data.
     *
     * @param flags The flags to be advertised.
     * @return The ConfigUriBeacon Builder.
     */
    public Builder flags(byte flags) {
      mBuilder.flags(flags);
      return this;
    }

    /**
     * Add a Uri to the ConfigUriBeacon advertised data.
     * @param uriString The Uri to be advertised.
     * @return The ConfigUriBeacon Builder.
     */
    public Builder uriString(String uriString) {
      mBuilder.uriString(uriString);
      return this;
    }

    /**
     * Add the bytes of a URI to the ConfigUriBeacon.
     * @param uriString The Uri to be advertised
     * @return The ConfigUriBeacon Builder
     */
    public Builder uriString(byte[] uriString) {
      mBuilder.uriString(uriString);
      return this;
    }

    /**
     * Add a Tx Power Level to the UriBeacon advertised data.
     * @param txPowerLevel The TX Power Level to be advertised.
     * @return The ConfigUriBeacon Builder.
     */
    public Builder txPowerLevel(byte txPowerLevel) {
      mBuilder.txPowerLevel(txPowerLevel);
      return this;
    }

    /**
     * Build ConfigUriBeacon.
     * @return The ConfigUriBeacon
     */
    public ConfigUriBeacon build() throws URISyntaxException {
      UriBeacon uriBeacon = mBuilder.build();
      return new ConfigUriBeacon(uriBeacon);
    }

  }
}
