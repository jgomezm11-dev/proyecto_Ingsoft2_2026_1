package co.vinni.clientes;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ClienteRecursoTest {

    private String crearCliente() {
        String id = UUID.randomUUID().toString();

        String json = """
        { "identificacion":"%s",
          "nombreCompleto":"pepe",
          "edad":15,
          "correo":"epatero@gmail.com",
          "telefono":"test"
        }
        """.formatted(id);

        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/clientes")
                .then()
                .log().all()
                .statusCode(201);

        return id;
    }

    @Test
    public void testCrearCliente() {
        crearCliente();
    }

    @Test
    public void testListaCliente() {
        crearCliente();

        given()
                .when()
                .get("/clientes")
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("correo", hasItems("epatero@gmail.com"));
    }

    /*@Test
    public void testModificarCliente() {
        String id = crearCliente();

        String jsonUpdate = """
        { "nombreCompleto":"juan",
          "edad":20,
          "correo":"juan@gmail.com",
          "telefono":"sistemas"
        }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(jsonUpdate)
                .when()
                .put("/clientes/" + id)
                .then()
                .statusCode(200);

        // 🔍 Validar que sí se actualizó
        given()
                .when()
                .get("/clientes")
                .then()
                .body("correo", hasItems("juan@gmail.com"))
                .body("nombreCompleto", hasItems("juan"));
    }

APITESTER

    http://localhost:8860/kick/clientes
    {
      "identificacion": "101023565",
      "nombreCompleto": "pepe",
      "edad": 15,
      "correo": "epatero@gmail.com",
      "telefono": "test"
    }

    http://localhost:8860/kick/clientes
    */
}