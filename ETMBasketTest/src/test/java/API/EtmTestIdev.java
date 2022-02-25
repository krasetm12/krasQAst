package API;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class EtmTestIdev {
  private final static String URL="https://idev.etm.ru/";
  @Test
  public void SuccessAutorization(){
    Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
    List<UserLoginData> userData= given()
            .when()
            .get(URL+"api/ipro/user/login?log=+79216572712&pwd=qakras123&city=78")
            .then().log().all()
            .extract().body().jsonPath().getList("data",UserLoginData.class);

  }


}
