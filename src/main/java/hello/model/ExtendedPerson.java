package hello.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("person ")
public class ExtendedPerson extends Person {

    @ApiModelProperty(required=false, value="person's  name")
    private String name;
    private String surname;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }
}
