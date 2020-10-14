package laba5_Pokitku;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plant implements countableCons{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Plant(String name)
    {
        this.name = name;
    }

    public int countCons()
    {
        Pattern cons = Pattern.compile("(?iu)[йцкнгшщзхфвпрлджчсмтб]");
        Matcher m = cons.matcher(this.name);
        int consCount = 0;
        while (m.find()) {
            consCount++;
        }
        return consCount;
    }

    public String info()
    {
        return "Растение - " + this.name;
    }
}
