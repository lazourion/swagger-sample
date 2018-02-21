package hello.api;

import hello.model.Greeting;
import hello.model.GreetingExtended;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "greeting", description = "the greeting API")
public interface GreetingApi {


    @ApiOperation(value = "Greeting 1",  response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok", response = Greeting.class),
            @ApiResponse(code = 400, message = "Bad request", response = Void.class),
            @ApiResponse(code = 404, message = "Not found", response = Void.class),
            @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    @RequestMapping(value="/greeting", produces = { "application/json" }, method = RequestMethod.GET)
    @CrossOrigin
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name);

    @ApiOperation(value = "Greeting 2", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok", response = GreetingExtended.class),
            @ApiResponse(code = 400, message = "Bad request", response = Void.class),
            @ApiResponse(code = 404, message = "Not found", response = Void.class),
            @ApiResponse(code = 409, message = "Balance already modified", response = Void.class),
            @ApiResponse(code = 500, message = "An unexpected error occured.", response = Error.class) })
    @RequestMapping(value="/anotherGreeting", produces = { "application/json" }, method = RequestMethod.GET)
    @CrossOrigin
    public Greeting anotherGreeting(@RequestParam(value = "name", defaultValue = "World") String name);

}
