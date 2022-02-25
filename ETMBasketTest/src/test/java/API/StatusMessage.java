package API;

public class StatusMessage {
  private Float code;
  private String message;

  public StatusMessage(Float code, String message) {
    this.code = code;
    this.message = message;
  }

  public Float getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
