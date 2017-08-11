package ir.msit87.amirdev_json.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import eu.amirs.JSON;
import ir.msit87.amirdev_json.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String simpleJsonString = "{\"id\":1, \"name\":\"A green door\",  \"price\":12.5,  \"tags\":[\"home\",\"green\"]}";
        JSON jsons = new JSON(simpleJsonString);

        Double priec = jsons.key("price").doubleValue();
        String firstIndex = jsons.key("tags").index(1).stringValue();

        JSON generatedJsonObject = JSON.create(JSON.dic("someKey", "someValue",
                "someArrayKey", JSON.array("first", 1, 2, JSON.dic("emptyArrayKey", JSON.array()))));

        //generatedJsonObject.addEditWithKey("someArrayKey","someOtherValue");


        generatedJsonObject.key("someArrayKey").removeWithIndex(1);

        generatedJsonObject.addEditWithKey("someArrayKey", "someOtherValue");

    }
}
