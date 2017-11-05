package hello.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("greeting ")
public class GreetingExtended extends Greeting {

    private final long id;

    @ApiModelProperty(required=false, value="Greeting content extended")
    private final String content;

    @ApiModelProperty(required=false, value="person")
    private ExtendedPerson person;

    public GreetingExtended(long id, String content) {
        super(id, content);
        this.id =id;
        this.content=content;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public ExtendedPerson getPerson() {
        return person;
    }
}
