package hello.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("greeting")
public class Greeting {

    private final long id;

    @ApiModelProperty(required=true, value="Greeting content")
    private final String content;

    @ApiModelProperty(required=true, value="person")
    private Person person;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Person getPerson() {
        return person;
    }
}
