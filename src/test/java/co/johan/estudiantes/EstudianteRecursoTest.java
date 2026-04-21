package co.johan.estudiantes;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class EstudianteRecursoTest {
    @Test
    public void testCrearEstudiante() {
        String json = """
        { "identificacion":"1010235",
          "nombreCompleto":"pepe",
          "edad":15,
          "correo":"epatero@gmail.com",
          "programaAcademico":"test"
        }
        """;
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                    .post("/estudiantes")
                .then()
                .statusCode(201);
    }
    @Test
    public void testListaEstudiante() {
        testCrearEstudiante();

        given()
                .when()
                    .get("/estudiantes")
                .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("nombre",hasItems("Elsa") )
                    .body("email",hasItems("epatero@gmail.com") );


    }
    @Test
    public void testCorreoInvalido() {
        String jsonInvalido = """
        { "nombre":"Elsa",
          "apellido":"Patero",
          "email":"epatero"
        }
        """;
        given()
                .contentType(ContentType.JSON)
                .body(jsonInvalido)
                .when()
                .post("/estudiantes")
                .then()
                    .statusCode(400)
                .body("mensaje",is("Error de validación en los datos de entrada") );
    }
}
