package exceptions;

public class NotSupportedBrowserException extends RuntimeException {
  public NotSupportedBrowserException(String browser) {
    super(String.format("Selected browser %s is not supported", browser));
  }
}

